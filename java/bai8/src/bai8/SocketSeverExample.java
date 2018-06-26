package bai8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;

import javax.xml.stream.events.StartDocument;

public class SocketSeverExample {

	public SocketSeverExample(int serverPort) {
		ServerSocket serverSock;
		try {
			serverSock = new ServerSocket(serverPort);
			System.out.println("SERVER Listening...");
			while (true) {
				Socket socket = serverSock.accept();
				Thread thread = new Thread(() -> {
					try (DataInputStream input = new DataInputStream(socket.getInputStream());
							DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
						System.out.println("client say: " + input.readUTF());
						output.writeUTF("I'm a socket server");

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}); thread.start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		SocketSeverExample socketSeverExample = new SocketSeverExample(6666);
	}
}
