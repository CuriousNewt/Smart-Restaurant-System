package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JFrame;

import Controller.Controller;
import Domain.Model.Item;
import Domain.Model.Menu;
import Domain.Model.Order;
import Domain.Model.Table;
import View.ServerGUI;

public class RmiServer implements RmiServerInterface {

	private Controller controller;
	private ArrayList<ClientInterface> clientList;
	private KitchenClientInterface kitchenInterface;
	private int clientID;
	private static ServerGUI gui;

	
		/**
	    * Constructor setting up Controller, ClientID and clientList.
	    * @param controller setting the local object controller.
	    */
	public RmiServer(Controller controller){
		this.controller = controller;
		clientID = 1;
		clientList = new ArrayList<ClientInterface>();
	}

	public static void main(String[] args) throws Exception {
		ModelManager manager = new ModelManager();

		Database database = new Database("databaseIP", manager);
		database.getMenu();

		Controller controller = new Controller(manager);

		Registry rmiRegistry = LocateRegistry.createRegistry(1099);
		RmiServerInterface rmiService = (RmiServerInterface) UnicastRemoteObject
				.exportObject(new RmiServer(controller), 1099);
		rmiRegistry.bind("RmiService", rmiService);
		
		gui = new ServerGUI(controller, database, rmiService);
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}

	
	/**
	* Method for calling show method from controller.
	* @param what String, declaring type of menu to show.
	* @return Menu object containing items.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	@Override
	public Menu show(String what) throws RemoteException {
		return controller.show(what);
	}

	
	/**
	* Method returning controller object.
	* @return Controller object.
	*/
	public Controller getController() {
		return controller;
	}

	/**
	* Method for calling showOrders method from controller to show orders on table. 
	* @param tableNumber Integer, declaring which table to show.
	* @return ArrayList of Items.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	@Override
	public ArrayList<Item> showOrders(int tableNumber) throws RemoteException {
		return controller.showOrders(tableNumber);
	}

	/**
	* Method for registering clients which connects to the server through RMI connection, setting their ID and creating their table object. 
	* @param clientInterface object to be registered.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	@Override
	public synchronized void registerForCallback(ClientInterface clientInterface)
			throws RemoteException {
		if (!(clientList.contains(clientInterface))) {
			clientList.add(clientInterface);
			if (clientInterface.getIDForKitchen() != 666) {
				clientInterface.setID(clientID);
				Table table = new Table(clientID);
				clientID++;
				gui.addTableToList(table);
				controller.addTable(table);
			}
		}
	}

	/**
	* Method for registering Kitchen client which connects to the server through RMI connection. 
	* @param kitchenInterface object to be registered.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	public synchronized void registerKitchenForCallBack(
			KitchenClientInterface kitchenInterface) throws RemoteException {
		this.kitchenInterface = kitchenInterface;
	}

	/**
	* Method updating the list in Kitchen client through RMI connection. 
	* @param order to be added to the list.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	public void updateKitchen(Order order) throws RemoteException {
		kitchenInterface.updateKitchen(order);
	}
	
	/**
	* Method removing from list in Kitchen client through RMI connection. 
	* @param item to be removed to the list.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	public void updateKitchenRemoveItem(Item item) throws RemoteException {
		kitchenInterface.updateKitchenRemoveItem(item);
	}

	
	/**
	* Method for adding items to order on selected table through RMI connection. 
	* @param ID Integer setting, which table made an order.
	*/
	@Override
	public synchronized void doCallbacks(int ID) {
		Order order;
		try {
			order = clientList.get(ID - 1).getOrder();
			for (int i = 0; i < order.size(); i++) {
				controller.addItemToOrder(order.getItem(i), ID - 1);
			}
			gui.updateListOfOrders(ID - 1);
		} catch (RemoteException e) {
			System.out.println("Something went wrong RMISERVER 140");
		}
	}

	/**
	* Method for updating menu on clients through RMI connection.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	public synchronized void updateMenuOfClients() throws RemoteException {
		for (int i = 0; i < clientList.size(); i++) {
			clientList.get(i).updateMenu();
		}
	}

	/**
	* Method for calling method in gui to open the JPane with call staff notification.
	* @param ID int indicates which table wants staff.
	*/
	@Override
	public void callStaff(int ID) {
		gui.callStaff(ID);
	}

	/**
	* Method for calling method in gui to open the JPane with notification about new order.
	* @param ID int indicates which table wants staff.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	@Override
	public void newOrderOnTable(int ID) throws RemoteException {
		gui.newOrderOnTable(ID);
	}

	

}
