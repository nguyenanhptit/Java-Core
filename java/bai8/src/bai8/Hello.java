package bai8;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
	public abstract String say(String name) throws RemoteException;

}