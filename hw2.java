import java.util.Arrays;
import java.util.Scanner;

public class hw2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		while (true) {
			try {
				input = scanner.nextLine();
				break;
			} catch (java.util.NoSuchElementException e) {
			}
		}
		scanner.close();

		// TODO: some how get the input to inputs array of integer
		int[] inputs = { 123, 234, 324325, 435 };

		boolean[] used = new boolean[inputs.length];
		for (int i = 0; i < used.length; i++) {
			used[i] = false;
		}

		int[] outputs = new int[inputs.length];

		for (int i = 0; i < inputs.length; i++) {
			outputs[i] = findMax(inputs, used);
		}

		for (int output : outputs) {
			System.out.printf("%d ", output);
		}
		System.out.println();
	}

	private static int findMax(int[] inputs, boolean[] used) {
		int max = inputs[0];
		for (int index = 0; index < inputs.length; index++) {
			if (!used[index] && inputs[index] > max) {
				max = inputs[index];
				used[index] = true;
			}
		}
		return max;
	}
}
