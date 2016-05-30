package Domain.Mediator;

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
import Utility.RmiServerInterface;
import View.ServerGUI;

public class RmiServer implements RmiServerInterface {

	private Controller controller;
	private ArrayList<ClientInterface> clientList;
	private KitchenClientInterface kitchenInterface;
	private int clientID;
	private static ServerGUI gui;

	public RmiServer(Controller controller, Database database) throws Exception {
		this.controller = controller;
		clientID = 1;
		clientList = new ArrayList<ClientInterface>();
		// thread.start();
	}

	public static void main(String[] args) throws Exception {
		ModelManager manager = new ModelManager();

		Database database = new Database("databaseIP", manager);
		database.getMenu();

		Controller controller = new Controller(manager);

		Registry rmiRegistry = LocateRegistry.createRegistry(1099);
		RmiServerInterface rmiService = (RmiServerInterface) UnicastRemoteObject
				.exportObject(new RmiServer(controller, database), 1099);
		rmiRegistry.bind("RmiService", rmiService);
		gui = new ServerGUI(controller, database, rmiService);

		// TODO delete sysout after everitynk yz fajn
		System.out.println("SERVER RUNS");

		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}

	@Override
	public Menu show(String what) throws RemoteException {
		return controller.show(what);
	}

	public Controller getController() {
		return controller;
	}

	@Override
	public ArrayList<Item> showOrders(int tableNumber) throws RemoteException {
		return controller.showOrders(tableNumber);
	}

	@Override
	public synchronized void registerForCallback(ClientInterface clientInterface)
			throws RemoteException {
		if (!(clientList.contains(clientInterface))) {
			clientList.add(clientInterface);
			if (clientInterface.getIDForKitchen() != 666) {
				clientInterface.setID(clientID);
				System.out.println(clientID);
				System.out.println("NEW CLIENT!");
				Table table = new Table(clientID);
				clientID++;
				gui.addTableToList(table);
				controller.addTable(table);
			}
		}
	}

	public synchronized void registerKitchenForCallBack(
			KitchenClientInterface kitchenInterface) throws RemoteException {
		this.kitchenInterface = kitchenInterface;
	}

	public void updateKitchen(Order order) throws RemoteException {
		kitchenInterface.updateKitchen(order);
	}
	public void updateKitchenRemoveItem(Item item) throws RemoteException {
		kitchenInterface.updateKitchenRemoveItem(item);
	}

	@Override
	public synchronized void doCallbacks(int ID) {
		Order order;
		try {
			order = clientList.get(ID - 1).getOrder();
			for (int i = 0; i < order.size(); i++) {
				controller.addItemToOrder(order.getItem(i), ID - 1);
			}
			System.out.println(clientList.get(0).toString());
			gui.updateListOfOrders(ID - 1);
		} catch (RemoteException e) {
			System.out.println("Something went wrong RMISERVER 140");
		}
	}

	public synchronized void updateMenuOfClients() throws RemoteException {
		for (int i = 0; i < clientList.size(); i++) {
			clientList.get(i).updateMenu();
		}
	}

	@Override
	public void callStaff(int ID) {
		gui.callStaff(ID);
	}

	@Override
	public void colourBackground(int ID) throws RemoteException {
		gui.colourBackground(ID);
	}

	

}
