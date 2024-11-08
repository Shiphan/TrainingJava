
// TODO: 
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class hw4 {
	public static void main(String[] args) {
		LocalDate date;

		System.out.println("輸入一個日期: (YYYY/MM/DD)");

		final var scanner = new Scanner(System.in);
		while (true) {
			final var input = scanner.nextLine();

			final var inputs = input.split("/");
			if (inputs.length != 3) {
				System.out.println("輸入`%s`不符合格式`YYYY/MM/DD`");
				continue;
			}
			final int year, month, dayOfMonth;
			try {
				year = Integer.parseInt(inputs[0]);
				month = Integer.parseInt(inputs[1]);
				dayOfMonth = Integer.parseInt(inputs[2]);
			} catch (java.lang.NumberFormatException e) {
				System.out.println("輸入`%s`不符合格式`YYYY/MM/DD`");
				continue;
			}

			try {
				date = LocalDate.of(year, month, dayOfMonth);
			} catch (java.time.DateTimeException e) {
				System.out.println("輸入`%s`不符合格式`YYYY/MM/DD`");
				continue;
			}
			break;
		}
		scanner.close();

		switch (date.getDayOfWeek()) {
			case MONDAY:
				System.out.println("星期一");
				break;
			case TUESDAY:
				System.out.println("星期二");
				break;
			case WEDNESDAY:
				System.out.println("星期三");
				break;
			case THURSDAY:
				System.out.println("星期四");
				break;
			case FRIDAY:
				System.out.println("星期五");
				break;
			case SATURDAY:
				System.out.println("星期六");
				break;
			case SUNDAY:
				System.out.println("星期天");
				break;
		}
		System.out.print(dateToCalendarString(date));
	}

	static String dateToCalendarString(LocalDate date) {
		final var builder = new StringBuilder();

		builder.append(String.format("Calendar of %d-%02d:\n", date.getYear(), date.getMonthValue()));
		builder.append("日\t一\t二\t三\t四\t五\t六\n");
		builder.append("\t".repeat(date.getDayOfWeek().getValue() % 7));

		for (int i = 1; i <= date.lengthOfMonth(); i++) {
			final var day = LocalDate.of(date.getYear(), date.getMonthValue(), i);
			builder.append(day.getDayOfMonth());

			if (day.getDayOfWeek() == DayOfWeek.SATURDAY || day.getDayOfMonth() == date.lengthOfMonth()) {
				builder.append('\n');
			} else {
				builder.append('\t');
			}
		}

		return builder.toString();
	}
}
