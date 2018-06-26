package bai11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("\\d+");
		String text = "2505+25 bang 550";
		Matcher matcher = pattern.matcher(text);
		int start = 0;
		while(matcher.find(start)) {
			start=matcher.start();
			int end = matcher.end();
			System.out.println("number:" + text.substring(start,end));
			start= end;
		}
		System.out.println(matcher.find());
		System.out.println("start= " + matcher.start()+ "-end "+matcher.end());
		System.out.println("value= " + text.substring(matcher.start(), matcher.end()));
	}

}
