package bai11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifiersRegexExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("t?\\S+(\\S)(.*)", Pattern.UNICODE_CHARACTER_CLASS);
		String text= "tớ học java";
		Matcher matcher= pattern.matcher(text);
//		System.out.println(text+ "--->" matcher.matches(text));
	}

}
