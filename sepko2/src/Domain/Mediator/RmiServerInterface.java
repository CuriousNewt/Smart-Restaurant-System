package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Controller.Controller;
import Domain.Model.Item;
import Domain.Model.Menu;
import Domain.Model.Order;

public interface RmiServerInterface extends Remote{

	/**
	* Server interface method for calling show method from controller through RMI connection.
	* @param what String, declaring type of menu to show.
	* @return Menu object containing items.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
    Menu show(String what) throws RemoteException;
    
    /**
	* Server interface method for getting controller object through RMI connection.
	* @return Controller object.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
    Controller getController() throws RemoteException;
    
    /**
	* Server interface method for showing orders on table through RMI connection. 
	* @param tableNumber Integer, declaring which table to show.
	* @return ArrayList of Items.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
    ArrayList<Item> showOrders(int tableNumber) throws RemoteException;
    
    /**
	* Server interface method for registering clients which connects to the server through RMI connection, setting their ID and creating their table object. 
	* @param clientInterface object to be registered.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
    void registerForCallback(ClientInterface clientInterface) throws RemoteException;
    
    /**
	* Server interface method for adding items to order on selected table through RMI connection. 
	* @param ID Integer setting, which table made an order.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
    void doCallbacks(int ID) throws RemoteException;
    
    /**
	* Server interface method for updating menu on clients through RMI connection.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
    void updateMenuOfClients() throws RemoteException;
    
    /**
	* Server interface method for calling staff through RMI connection.
	* @param ID int indicates which table wants staff.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void callStaff(int ID) throws RemoteException;
	
	/**
	* Server interface method for notifing staff about new order.
	* @param ID int indicates which table wants staff.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void newOrderOnTable(int ID) throws RemoteException;
	
	/**
	* Server interface method for registering Kitchen client which connects to the server through RMI connection. 
	* @param kitchenInterface object to be registered.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void registerKitchenForCallBack(KitchenClientInterface kitchenInterface) throws RemoteException;
	
	/**
	* Server interface method for updating the list in Kitchen client through RMI connection. 
	* @param order to be added to the list.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void updateKitchen(Order order) throws RemoteException;
	
	/**
	* Server interface method removing from list in Kitchen client through RMI connection. 
	* @param item to be removed to the list.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	void updateKitchenRemoveItem(Item item) throws RemoteException;
}