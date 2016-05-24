package Domain.Mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Domain.Model.Order;

public interface ClientInterface extends Remote {
	void setID(int ID) throws RemoteException;
	public Order getOrders() throws RemoteException;
	public void callStaff()  throws RemoteException;
	
	
}
