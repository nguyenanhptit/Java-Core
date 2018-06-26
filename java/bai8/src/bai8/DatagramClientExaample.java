package bai8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClientExaample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("localhost");
		String str = "client say xin chao";
		byte[] bytes = str.getBytes();
		DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address,6666);
		socket.send(packet);
		packet= new DatagramPacket(bytes, bytes.length);
		socket.receive(packet);
		System.out.println("from server: "+ new String(packet.getData(),0,packet.getLength()));
		socket.close();
	}

}
