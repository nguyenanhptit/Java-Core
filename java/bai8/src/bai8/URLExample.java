package bai8;


import java.net.MalformedURLException;
import java.net.URL;

public class URLExample {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		  String link = "https://www.google.com.vn/search?q=hello";
		URL url = new URL(link);
		System.out.println("protocol "+ url.getProtocol());
		System.out.println("Port "+ url.getPort());
		System.out.println("query "+ url.getQuery());
	}

}
