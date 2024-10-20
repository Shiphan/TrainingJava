
/*
 * 作者: 林祐廷 學號: 111216017
 * 操作說明: TODO:
 * 自評:
 * 額外說明:
 *   有處理錯誤輸入的情況
 */

import java.util.ArrayList;
import java.util.Scanner;

public class hw2 {
	public static void main(String[] args) {
		String inputStr = "";
		ArrayList<Integer> inputs = new ArrayList<Integer>();

		Scanner scanner = new Scanner(System.in);
		boolean validInput;
		do {
			inputs.clear();
			validInput = true;
			try {
				inputStr = scanner.nextLine();
			} catch (java.util.NoSuchElementException e) {
				validInput = false;
				continue;
			}
			if (inputStr.isBlank()) {
				validInput = false;
			}
			for (String str : inputStr.strip().split(" +")) {
				try {
					inputs.add(Integer.parseInt(str));
				} catch (java.lang.NumberFormatException e) {
					validInput = false;
					System.out.printf("`%s`不能作為整數使用\n", str);
					break;
				}
			}
		} while (!validInput);
		scanner.close();

		boolean[] used = new boolean[inputs.size()];
		for (int i = 0; i < used.length; i++) {
			used[i] = false;
		}

		for (int i = 0; i < inputs.size(); i++) {
			System.out.printf("%d ", findMax(inputs, used));
			// findMax(inputs, used);
		}
		System.out.println();
	}

	private static int findMax(ArrayList<Integer> inputs, boolean[] used) {
		int maxIndex = -1;
		for (int index = 0; index < inputs.size(); index++) {
			if (!used[index]) {
				maxIndex = index;
				break;
			}
		}
		for (int index = 0; index < inputs.size(); index++) {
			if (!used[index] && inputs.get(index) > inputs.get(maxIndex)) {
				maxIndex = index;
			}
		}
		used[maxIndex] = true;
		return inputs.get(maxIndex);
	}
}
