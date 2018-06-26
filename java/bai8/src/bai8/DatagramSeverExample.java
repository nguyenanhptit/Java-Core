package bai8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class DatagramSeverExample{
public DatagramSeverExample() throws SocketException {
//	DatagramSocket socket = new DatagramSocket(4445);
//	System.out.println("data server listening...");
}

public void run() throws IOException {
	byte[] bytes = null;
	// TODO Auto-generated method stub
	DatagramPacket packet = new DatagramPacket(bytes, bytes.length );
	DatagramSocket socket = new DatagramSocket(4445);
	socket.receive(packet);
	System.out.println("from client:"+ new String(packet.getData(),0, packet.getLength()));
	socket.send(new DatagramPacket(bytes, bytes.length, packet.getAddress(), packet.getPort()));

}
public static void main(String[] args) {
	Thread thread = new Thread();
	thread.start();
}
}
