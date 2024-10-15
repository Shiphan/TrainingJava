import java.util.Scanner;

public class java_1 {
	public static void main(String[] args) {
		int num = 2;
		long l = 1000L;
		byte b = 0x12;
		char c = '\u0065';
		System.out.println(String.format("hello world! (%d)", num));
		System.out.printf("|%+010f|", 66f);

		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.printf("|%s|\n", s.trim());
		scanner.close();
		int i[] = new int[100];
	}
}
