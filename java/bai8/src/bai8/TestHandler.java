package bai8;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TestHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub
		String message= "<html><h2>this is the reponse</h2></html>";
		 exchange.sendResponseHeaders(200, message.length());
		
		 try( OutputStream  out = exchange.getResponseBody()){
			 out.write(message.getBytes());
		 }
			 
		 
	}
}
