package Longngu;

public class StringExample1 {
	public static void main(String[] args) {
		String text = "say hello to everyone";
	System.out.println("length of text is "+ text.length());
	System.out.println("vi tri tu hello "+ text.indexOf("hello"));
	System.out.println("cat tu "+ text.substring(4,8));
	char[] chars = {'h','e','l','l','o'};
	String text1 = new String(chars);
	System.out.println( text);
	text1 = text.concat("");
	text1 = text.concat(args[0]);
	System.out.println("new value is "+ text);
	System.out.println("hello java" .equals(text));
		 
//		String text = "say hello to everyone";
//		System.out.println("length of text is "+ text.length());
//		int i=0;
//		while (i< text.length()) {
//			char c= text.charAt(i);
//			if(c== '0') {
//				i++;
//				continue;
//			}
//			System.out.println("character "+ i+ "is"+c);
//			i++;
//		}
	}
}