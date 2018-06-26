package bai8;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class HttpHeaderExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL( "https://google.com.vn/");
		URLConnection connection = url.openConnection();
		System.out.println("http method"+ connection.getRequestProperty(null));
		Map<String, List<String>> headers = connection.getHeaderFields();
		BiConsumer<String, List<String>> header = (key,values)->{
			System.out.println("key"+ key + "vualues"+ values);
		};
	headers.forEach(header);
	}

}
