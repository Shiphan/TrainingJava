// Please open this file with UTF-8 encoding.

/*
 * 作者: 林祐廷 學號: 111216017
 * 操作說明:
 *   輸入一行以空格相隔的整數數列, 例如: `123 4 56 -78 4 9 10`
 *   將輸出該數列從大到小排序後的結果, 例如: `123 56 10 9 4 4 -78 `
 * 自評: 100%
 *   1. 程式有意義且可以執行 (+10%)
 *       符合題目且可以執行
 *   2. 正確顯示答案 (+70%)
 *       答案正確
 *   3. 會偵測輸入是否不為整數 (+20%)
 *       會偵測輸入是否不為整數
 *   4. 程式檔案沒有遵照規定命名 (-10%)
 *       正確的檔案名稱
 *   5. 主程式開始沒有包含作者、操作說明及符合的評分標準等資訊 (即不遵守作業繳交通則C) (-10%)
 *       符合
 *   6. 程式沒有適當註解 (-10%)
 *       有充分註解
 *   7. 抄襲 (上述評分不計, 直接 -50%)
 *       自己寫的, 沒抄襲
 * 額外說明:
 *   即使有多餘的空格也能正確執行
 */

import java.util.ArrayList;
import java.util.Scanner;

public class hw2 {
	public static void main(String[] args) {
		// 取得輸入數列
		ArrayList<Integer> inputs = getInput();

		// 初始化一個與輸入同樣長度且全是false的boolean array
		boolean[] used = new boolean[inputs.size()];
		for (int i = 0; i < used.length; i++) {
			used[i] = false;
		}

		// 從最大的開始輸出, 每次都會將輸出過的項目標記為已使用並不再作為最大值輸出
		for (int i = 0; i < inputs.size(); i++) {
			System.out.printf("%d ", findMax(inputs, used));
		}
		System.out.println();
	}

	private static ArrayList<Integer> getInput() {
		// 取得使用者的輸入並存入inputStr
		Scanner scanner = new Scanner(System.in);
		String inputStr = "";

		// 儲存處理後的輸入
		ArrayList<Integer> inputs = new ArrayList<Integer>();

		// 直到取得正確的輸入前, 接收輸入
		boolean validInput;
		do {
			inputs.clear();
			validInput = true;

			// 如果得到EOF就當作空的數列
			try {
				inputStr = scanner.nextLine();
			} catch (java.util.NoSuchElementException e) {
				scanner.close();
				return inputs;
			}

			// 如果是空白行就繼續等待輸入
			if (inputStr.isBlank()) {
				validInput = false;
				continue;
			}

			// 用空白分割數列中的元素, 並將每個元素轉換為整數
			for (String str : inputStr.strip().split(" +")) {
				// 如果該元素不能轉換為整數, 提示使用者輸入有誤, 並等待新的輸入
				try {
					inputs.add(Integer.parseInt(str));
				} catch (java.lang.NumberFormatException e) {
					validInput = false;
					System.out.printf("`%s`不能作為整數使用, 請重新輸入\n", str);
					break;
				}
			}
		} while (!validInput);
		scanner.close();

		return inputs;
	}

	private static int findMax(ArrayList<Integer> inputs, boolean[] used) {
		// 找到第一個沒被使用過的元素
		int maxIndex = -1;
		for (int index = 0; index < inputs.size(); index++) {
			if (!used[index]) {
				maxIndex = index;
				break;
			}
		}
		// 比較每個未使用的元素, 並找到最大的索引值
		for (int index = 0; index < inputs.size(); index++) {
			if (!used[index] && inputs.get(index) > inputs.get(maxIndex)) {
				maxIndex = index;
			}
		}

		// 將找到的最大值設為已使用, 並回傳最大值
		used[maxIndex] = true;
		return inputs.get(maxIndex);
	}
}
