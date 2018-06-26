package Bai22;

import java.util.Calendar;
import java.util.Locale;

public class StringSwitchStatement {
	private static final int DATE = 0;
	static String getTypeOfDay(Calendar calendar) {
		System.out.println(calendar.getTime());
		String type = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("vi"));
		System.out.println(type);
		switch (type) {
		case"Th 2":
			return "start of work week";
		case"Th 3":
		case"Th 4":
		case"Th 5":
			return "midweek";
		case"Th 6":
			return "end of work week";
		case"Th 7":
		case"Cn":
			return "weekend";
		}
		return "unknown";
	}
	public static void main(String[] args) {
		StringSwitchStatement statement = new StringSwitchStatement();
		Calendar calendar = Calendar.getInstance();
		System.out.println("today is "+ statement.getTypeOfDay(calendar));
		System.out.println(calendar.get(DATE));
		calendar.set(Calendar.DATE, calendar.get(DATE)+1);
		System.out.println("tomorow is "+ getTypeOfDay(calendar));
	}
}
