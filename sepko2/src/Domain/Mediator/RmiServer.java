package Domain.Mediator;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Controller.Controller;
import Domain.Model.Item;
import Domain.Model.Menu;
import Domain.Model.Order;
import Domain.Model.Table;
import Utility.RemoteObserver;
import Utility.RmiServerInterface;
import View.ServerGUI;

public class RmiServer extends Observable implements RmiServerInterface {

	private Controller controller;
	private ArrayList<ClientInterface> clientList;
	private int clientID;
	private static ServerGUI gui;

	/*
	 * Thread thread = new Thread() {
	 * 
	 * @Override public void run() { while (true) { try { Thread.sleep(10000); }
	 * catch (InterruptedException e) { } setChanged(); try {
	 * notifyObservers(show("menu")); } catch (RemoteException e) {
	 * e.printStackTrace(); } } }; };
	 */

	private class WrappedObserver implements Observer, Serializable {

		private static final long serialVersionUID = 1L;

		private RemoteObserver observer;
		private int id;

		public WrappedObserver(RemoteObserver observer) {
			this.observer = observer;
			this.id = RmiClient.getID();
		}

		public int id() {
			return this.id;
		}

		@Override
		public void update(Observable o, Object argument) {
			try {
				observer.update(o.toString(), argument);
			} catch (RemoteException e) {
				System.out.println("Remote exception removing table no. "
						+ id());
				o.deleteObserver(this);
			}
		}
	}

	public RmiServer(Controller controller) throws Exception {
		this.controller = controller;
		this.gui = new ServerGUI(controller);
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
				.exportObject(new RmiServer(controller), 1099);
		rmiRegistry.bind("RmiService", rmiService);

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
	public void addObserver(RemoteObserver o) throws RemoteException {
		WrappedObserver observer = new WrappedObserver(o);
		addObserver(observer);
		System.out.println("Table Number " + observer.id()
				+ " connected to server.");
	}

	@Override
	public synchronized void registerForCallback(ClientInterface clientInterface) throws RemoteException {
		if (!(clientList.contains(clientInterface))) {
			clientList.add(clientInterface);
			clientInterface.setID(clientID);
			System.out.println(clientID);
			System.out.println("NEW CLIENT!");
			Table table = new Table(clientID);
			clientID++;
			gui.addTableToList(table);
		}
	}

	@Override
	public synchronized void doCallbacks(int ID) {
		Order order;
		try {
			order = clientList.get(ID - 1).getOrder();
			for(int i = 0; i < order.size(); i++){
				controller.addItemToOrder(order.getItem(i), ID-1);
			}
			System.out.println(clientList.get(0).toString());
			gui.updateListofOrders(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void callStaff(int ID) {
		gui.callStaff(ID);
	}

}
