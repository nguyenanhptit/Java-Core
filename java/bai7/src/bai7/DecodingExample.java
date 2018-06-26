package bai7;

import java.io.UnsupportedEncodingException;

public class DecodingExample {


//private static final int Integer = 0;

public static void main(String[] args) {
	byte [] values = {120,105,110,32,99,104,-61,-96,111};
//	byte [] bytes = new byte[Integer];
//	for ( int i=0; i< bytes.length; i++) {
//		bytes =  ()values[i];
		
//	}
try {
	System.out.println(new String(values, "utf8"));
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}

