
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
		Scanner scanner = new Scanner(System.in);
		int i = 0;

		boolean validInput;
		do {
			try {
				i = scanner.nextInt();
				validInput = true;
			} catch (java.util.InputMismatchException e) {
				validInput = false;
				System.out.printf("`%s`不能作為整數或超過整數的容量\n", scanner.next());
				continue;
			}
			if (i <= 0) {
				validInput = false;
				System.out.printf("%d不是大於0的整數\n", i);
			}
		} while (!validInput);
		scanner.close();

		if (i == 1) {
			System.out.println("否");
			System.out.println("1沒有質因數");
			return;
		}

		ArrayList<Integer> factors = new ArrayList<Integer>();
		int remain = i;

		while (remain != 1) {
			int num = 2;
			if (!factors.isEmpty()) {
				num = factors.getLast();
			}
			for (; num <= remain; num++) {
				if (remain % num == 0) {
					factors.add(num);
					remain = remain / num;
					break;
				}
			}
		}

		if (factors.size() == 1) {
			System.out.println("是");
		} else {
			System.out.println("否");
		}

		System.out.printf("%d = ", i);

		System.out.println(String.join(" * ", factors.stream().map((f) -> Integer.toString(f)).toList()));
	}
}
