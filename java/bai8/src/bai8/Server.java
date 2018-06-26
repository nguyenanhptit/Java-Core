package bai8;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

	@Override
	public String say(String name) {
		return "Hello:" + name;
	}

	public static void main(String[] args) {
		System.setProperty("java.rmi.server.hostname", "127.0.0.100");
		Server obj = new Server();
		try {
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
			Registry registry = LocateRegistry.getRegistry("127.0.0.100", 8000);
			registry.bind("Hello", stub);
			System.out.println("servere ready");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
