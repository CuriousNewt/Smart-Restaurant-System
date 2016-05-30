package Domain.Mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Domain.Model.Item;
import Domain.Model.Order;

public interface KitchenClientInterface extends Remote {
	void updateKitchen(Order order) throws RemoteException;
	void updateKitchenRemoveItem(Item item) throws RemoteException;
}
