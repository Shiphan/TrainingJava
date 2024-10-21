// Please open this file with UTF-8 encoding.

import java.util.Random;
import java.util.Scanner;

public class hw3 {
	public static void main(String[] args) {
		int[] answer = initAnswer();

		Scanner scanner = new Scanner(System.in);
		boolean win = false;

		for (int time = 0; time < 10; time++) {
			int[] input = getInput(scanner);

			int a = 0;
			int b = 0;
			for (int index = 0; index < 4; index++) {
				for (int indexAns = 0; indexAns < 4; indexAns++) {
					if (input[index] == answer[indexAns]) {
						if (index == indexAns) {
							a++;
						} else {
							b++;
						}
					}
				}
			}
			if (a == 4) {
				System.out.printf("恭喜答對, 您猜了%d次!\n", time + 1);
				win = true;
				break;
			}
			System.out.printf("%dA%dB\n", a, b);
			System.out.println();
		}
		scanner.close();

		if (!win) {
			System.out.print("已經10次了! 正確答案是: ");
			for (int a : answer) {
				System.out.printf("%d", a);
			}
			System.out.println();
		}
	}

	private static int[] initAnswer() {
		Random random = new Random();

		int[] answer = new int[4];

		for (int index = 0; index < answer.length; index++) {
			boolean unused;
			do {
				unused = true;
				answer[index] = random.nextInt(0, 10);
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
		int[] input = new int[4];

		Boolean validInput;
		do {
			validInput = true;

			String inputStr = scanner.next();
			if (inputStr.length() != 4) {
				validInput = false;
				System.out.printf("`%s`的長度不是4個字元\n", inputStr);
				continue;
			}

			for (int index = 0; index < 4 && validInput; index++) {
				try {
					input[index] = Integer.parseInt(Character.toString(inputStr.charAt(index)));
				} catch (java.lang.NumberFormatException e) {
					validInput = false;
					System.out.printf("`%c`不是數字\n", inputStr.charAt(index));
					break;
				}
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
