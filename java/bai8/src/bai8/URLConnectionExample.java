package bai8;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;

public class URLConnectionExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL( "https://google.com.vn/");
		URLConnection connection = url.openConnection();
		InputStream stream = connection.getInputStream();
		int read;
		byte[] bytes = null;
		while((read= stream.read(bytes))!=-1) {
		System.out.println(new String(bytes,0,read));	
		}
	}

}
