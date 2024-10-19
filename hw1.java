
// TODO: 寫註解
/*
 * 作者: 林祐廷 學號: 111216017
 * 說明:
 *   使用者輸入一個大於0的整數, 將輸出該數字是否為質數, 以及該數字的質因數分解結果
 *
 *
 *
 *
 *
 *
 *
 *
*/

import java.util.ArrayList;
import java.util.Scanner;

public class hw1 {
	public static void main(String[] args) {
		// 取得使用者輸入存入i
		int i = getInput();

		// 先處理輸入為1的情況
		if (i == 1) {
			System.out.println("否");
			System.out.println("1沒有質因數");
			return;
		}

		// 創造一個ArrayList儲存質因數
		ArrayList<Integer> factors = new ArrayList<Integer>();

		// 將剩餘數值設為i
		int remain = i;

		/*
		 * 1. 從前一個找到的質因數(如果沒有就從最小的質數2)開始測試能否整除剩餘的數字(remain),
		 *     若可以, 將該數字(num)存入質因數數列(factors),
		 *     並將除以num後的數值存入remain
		 *     (不會找到任何和數作為因數因為會先找到那個和數的因數)
		 * 2. 重複執行以上步驟直到remain == 1, 也就是找到所有質因數
		 */
		while (remain != 1) {
			// 要從多大的數字開始嘗試, 預設為2, 若前面已經有算出的質因數, 則從前一個算出的質因數開始
			int num = 2;
			if (!factors.isEmpty()) {
				num = factors.getLast();
			}

			// 從起始數字開始, 檢查該數字使否是目標的因數
			for (; num <= remain; num++) {
				if (remain % num == 0) {
					// 若是因數, 將這個數字儲存起來
					factors.add(num);
					remain = remain / num;
					break;
				}
			}
		}

		// 若只有一個質因數, 則輸入是一個質數
		if (factors.size() == 1) {
			System.out.println("是");
		} else {
			System.out.println("否");
		}

		// 輸出i的質因數
		System.out.printf("%d = ", i);
		System.out.println(String.join(" * ", factors.stream().map((f) -> Integer.toString(f)).toList()));
	}

	private static int getInput() {
		// 取得使用者的輸入
		Scanner scanner = new Scanner(System.in);
		int i = 0;

		// 直到取得正確的輸入前, 接收輸入
		boolean validInput;
		do {
			validInput = true;
			try {
				i = scanner.nextInt();
			} catch (java.util.InputMismatchException e) {
				// 處理不能作為int的輸入
				validInput = false;
				System.out.printf("`%s`不能作為整數或超過整數的容量\n", scanner.next());
				continue;
			}

			// 處理不是大於0的輸入
			if (i <= 0) {
				validInput = false;
				System.out.printf("%d不是大於0的整數\n", i);
			}
		} while (!validInput);
		scanner.close();

		return i;
	}
}
