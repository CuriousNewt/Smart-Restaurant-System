package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.rmi.Remote;
import java.rmi.RemoteException;

import Domain.Model.Item;
import Domain.Model.Order;

public interface ClientInterface extends Remote {
	
	/**
	* Client interface method for setting up ID variable on client from server through RMI connection.
	* @param ID Integer, declaring what ID will the client have.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void setID(int ID) throws RemoteException;
	/**
	* Client interface method for getting an order from client to server through RMI connection.
	* @return Order Order of items ordered by client.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	Order getOrder() throws RemoteException;
	/**
	* Client interface method for giving confirmation from server through RMI connection if the staff is called.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void callStaff()  throws RemoteException;
	/**
	* Client interface method for updating menu from server on client through the RMI connection.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void updateMenu() throws RemoteException;
	/**
	* Client interface method for getting ID from client to server through the RMI connection.
	* @return int ID of the client.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	int getIDForKitchen() throws RemoteException;
	
	
	/**
	* Client interface method setting order object from client to server through the RMI connection.
	* @param order Order object.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void setOrder(Order order) throws RemoteException;
}
