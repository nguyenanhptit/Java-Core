package bai11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupRegexExample {

	public static void main(String[] args) {
		//int UNICODE_CHARACTED_CLASS = 0;
		// TODO Auto-generated method stub
		Pattern patten = Pattern.compile("\\w + (\\+S)(\\.*)", Pattern.UNICODE_CASE);
		String text = "ganfj asjdf giaso 5958 ????";
		Matcher matcher = patten.matcher(text);
		System.out.println(matcher.matches());
		System.out.println(matcher.group(1));
		System.out.println(matcher.group(2));
	}

}
