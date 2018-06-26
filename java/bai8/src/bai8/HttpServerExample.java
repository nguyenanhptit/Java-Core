package bai8;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HttpServerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress(8080),0);
			HttpHandler testHandler= null;
			server.createContext("/test", testHandler);
			server.setExecutor(Executors.newFixedThreadPool(5));
			server.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			

		}
}
