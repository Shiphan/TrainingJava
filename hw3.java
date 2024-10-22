// Please open this file with UTF-8 encoding.

/*
 * 作者: 林祐廷 學號: 111216017
 * 操作說明:
 * 自評: 93%
 *   1. 程式有意義且可以執行 (+20%)
 *       符合題目且可以執行
 *   2. 完成遊戲 (+70%)
 *       完成遊戲
 *   3. 其他特殊功能 (+10%)
 *       提示玩家嘗試的次數(+3%)
 *   4. 程式檔案沒有遵照規定命名 (-10%)
 *       正確的檔案名稱
 *   5. 主程式開始沒有包含作者、操作說明及符合的評分標準等資訊 (即不遵守作業繳交通則C) (-10%)
 *       符合
 *   6. 程式沒有適當註解 (-10%)
 *       有充分註解
 *   7. 抄襲 (上述評分不計, 直接 -50%)
 *       自己寫的, 沒抄襲
 * 額外說明:
 *   有處理錯誤輸入的情況
 */

import java.util.Random;
import java.util.Scanner;

public class hw3 {
	private static final int LEN = 4;
	private static final int CHANCE = 10;

	public static void main(String[] args) {
		// 產生一個隨機的答案
		int[] answer = initAnswer();

		System.out.println("幾A幾B:");
		System.out.printf("1. 答案由%d個不重複的數字組成\n", LEN);
		System.out.printf("2. 請同樣輸入%d個不重複的數字組成的猜測\n", LEN);
		System.out.println("3. 猜測的數字包含在答案中算一個'B', 如果位置也猜對就算一個'A'");
		System.out.printf("4. 總共有%d次機會, 祝你好運!\n", 10);
		System.out.println();

		Scanner scanner = new Scanner(System.in);
		boolean win = false;

		// 提供CHANCE次嘗試的機會, 如果提前答對就提前結束
		for (int time = 0; time < CHANCE && !win; time++) {
			System.out.printf("第%d次嘗試:\n", time + 1);

			// 取得使用者的猜測
			int[] input = getInput(scanner);

			// 將結果儲存在a和b
			int a = 0;
			int b = 0;

			// 檢查每個輸入數字
			for (int index = 0; index < LEN; index++) {
				// 檢查這個數字是否有出現在答案當中
				for (int indexAns = 0; indexAns < LEN; indexAns++) {
					if (input[index] == answer[indexAns]) {
						// 找到有在答案中的數字後檢查有沒有猜中位置
						if (index == indexAns) {
							a++;
						} else {
							b++;
						}
						break;
					}
				}
			}

			// 列印結果
			System.out.printf("%dA%dB\n", a, b);
			System.out.println();

			// 如果完全猜對了, 就提前結束
			if (a == LEN) {
				System.out.printf("恭喜答對, 您猜了%d次!\n", time + 1);
				win = true;
			}
		}
		scanner.close();

		// 如果已經結束了但還沒有猜中, 公布正確答案
		if (!win) {
			System.out.printf("已經%d次了! 正確答案是: ", CHANCE);
			for (int a : answer) {
				System.out.printf("%d", a);
			}
			System.out.println();
		}
	}

	private static int[] initAnswer() {
		Random random = new Random();

		int[] answer = new int[LEN];

		// 初始化每個答案數字
		for (int index = 0; index < LEN; index++) {
			// 重複初始化直到沒有跟前面的答案重複
			boolean unused;
			do {
				unused = true;
				answer[index] = random.nextInt(0, 10);
				// 檢查有沒有跟前面的答案重複
				for (int indexPre = 0; indexPre < index; indexPre++) {
					if (answer[index] == answer[indexPre]) {
						unused = false;
						break;
					}
				}
			} while (!unused);
		}

		return answer;
	}

	private static int[] getInput(Scanner scanner) {
		int[] input = new int[LEN];

		// 接收新的輸入如果輸入不合法
		Boolean validInput;
		do {
			validInput = true;

			String inputStr = scanner.next();

			// 檢查輸入的長度是否正確
			if (inputStr.length() != LEN) {
				validInput = false;
				System.out.printf("`%s`的長度不是%d個字元\n", inputStr, LEN);
				continue;
			}

			// 處理每個輸入的字元
			for (int index = 0; index < LEN && validInput; index++) {
				// 將輸入轉換為整數, 並處理不能轉換的情況
				try {
					input[index] = Integer.parseInt(Character.toString(inputStr.charAt(index)));
				} catch (java.lang.NumberFormatException e) {
					validInput = false;
					System.out.printf("`%c`不是數字\n", inputStr.charAt(index));
					break;
				}

				// 檢查這個數字有沒有跟前面的重複
				for (int indexPre = 0; indexPre < index; indexPre++) {
					if (input[index] == input[indexPre]) {
						validInput = false;
						System.out.println("不能有重複的數字");
						break;
					}
				}
			}
		} while (!validInput);

		return input;
	}
}
