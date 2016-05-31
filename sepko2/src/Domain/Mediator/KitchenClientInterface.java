package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.rmi.Remote;
import java.rmi.RemoteException;

import Domain.Model.Item;
import Domain.Model.Order;

public interface KitchenClientInterface extends Remote {
	void updateKitchen(Order order) throws RemoteException;
	void updateKitchenRemoveItem(Item item) throws RemoteException;
}
