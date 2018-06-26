package Bai22;


import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;

public class MessageFormatExample {
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat ("EEEEE, dd MMMMM yyyy");
		String message = MessageFormat.format("hello{0}! today is {1}.", args[0], dateFormat.format(Calendar.getInstance().getTime()));
		System.out.println(message);
	}
}
