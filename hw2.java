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

	}
}
