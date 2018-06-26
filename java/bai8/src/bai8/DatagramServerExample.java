package bai8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerExample implements Runnable {
	public DatagramServerExample() {
		// TODO Auto-generated constructor stub
		try {
			DatagramSocket socket = new DatagramSocket(4445);
			System.out.println("data server listening...");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(6666);
			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			System.out.println("from client: " + new String(packet.getData(), 0, packet.getLength()));
			String str = "server say hello";
			byte[] bytes = str.getBytes();
			socket.send(new DatagramPacket(bytes, bytes.length, packet.getAddress(), packet.getPort()));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			socket.close();
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new DatagramServerExample());
		thread.start();
	}

}
