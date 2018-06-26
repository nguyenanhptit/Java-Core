package bai8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.omg.CORBA_2_3.portable.OutputStream;

public class SocketClientExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		Socket socket = null;
		try {
			socket = new Socket("localhost", 6666);
			System.out.println("client start sending..");
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			dataOutputStream.writeUTF("hello world!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}