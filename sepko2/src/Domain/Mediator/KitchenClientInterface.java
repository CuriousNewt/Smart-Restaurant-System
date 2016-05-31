package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.rmi.Remote;
import java.rmi.RemoteException;

import Domain.Model.Item;
import Domain.Model.Order;

public interface KitchenClientInterface extends Remote {

	/**
	* Kitchen interface method for updating list of meal orders by server through RMI connection.
	* @param order Order, which is added to the list.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void updateKitchen(Order order) throws RemoteException;
	
	/**
	* Kitchen interface method for removing meal from list of meals by server through RMI connection.
	* @param item Item, which is removed from the list.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void updateKitchenRemoveItem(Item item) throws RemoteException;
}
