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
import Domain.Model.Menu;
import Domain.Model.Order;
import Utility.RemoteObserver;
import Utility.RmiService;
import View.ServerGUI;

public class RmiServer extends Observable implements RmiService {

	private Controller controller;
	
	private class WrappedObserver implements Observer, Serializable {

		private static final long serialVersionUID = 1L;

		private RemoteObserver observer;

		public WrappedObserver(RemoteObserver observer) {
			this.observer = observer;
		}

		@Override
		public void update(Observable o, Object argument) {
			try {
				observer.update(o.toString(), argument);
			} catch (RemoteException e) {
				System.out
						.println("Remote exception removing observer:" + this);
				o.deleteObserver(this);
			}
		}

	}

	@Override
	public Menu show(String what) throws RemoteException {
		return controller.show(what);
	}
	@Override
	public ArrayList<Order> showOrders() throws RemoteException {
		return controller.showOrders();
	}

	@Override
	public void addObserver(RemoteObserver o) throws RemoteException {
		WrappedObserver observer = new WrappedObserver(o);
		addObserver(observer);
		System.out.println("Added observer:" + observer);
	}

	Thread thread = new Thread() {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
				}
				setChanged();
				try {
					notifyObservers(show("menu"));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		};
	};

	public RmiServer(Controller controller) {
		this.controller = controller;
		thread.start();
	}

	public static void main(String[] args) throws Exception {
		ModelManager manager = new ModelManager();
		Controller controller = new Controller(manager);

		try {
			Registry rmiRegistry = LocateRegistry.createRegistry(1099);
			RmiService rmiService = (RmiService) UnicastRemoteObject
					.exportObject(new RmiServer(controller), 1099);
			rmiRegistry.bind("RmiService", rmiService);
			// TODO delete sysout after everitynk yz fajn
			System.out.println("SERVER RUNS");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		ServerGUI gui = new ServerGUI();
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}
}