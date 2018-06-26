package Bai22;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTimeFormat {
	public static void main(String[] args) {
		Locale locale = new Locale ("vi","VN");
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, dd MMMMM yyyy", locale);
		Calendar calendar = Calendar.getInstance();
		System.out.println (calendar.getTime());

	}
}
