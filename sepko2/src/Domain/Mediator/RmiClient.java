package Domain.Mediator;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;

import Controller.Controller;
import Domain.Model.*;
import Utility.RemoteObserver;
import Utility.RmiServerInterface;
import View.ClientGUI;

public class RmiClient extends UnicastRemoteObject implements RemoteObserver,ClientInterface,
		Serializable {

	private static int ID;
	private static final long serialVersionUID = 1L;
	private RmiServerInterface service;
	private Order order;

	protected RmiClient(RmiServerInterface service) throws RemoteException,
			FileNotFoundException {
		super();
		this.service = service;

	}

	public static int getID() {
		return ID;
	}

	public Menu getMenu() throws RemoteException {
		return this.service.show("menu");
	}

	public Menu get(String what) throws RemoteException {
		return this.service.show(what);

	}

	public Controller getController() throws RemoteException {
		return this.service.getController();
	}

	public static void main(String[] args) throws Exception {
		String ip = ReadIP.getReadIP("ServerIPaID").getIP();
		ip = "//" + ip + ":1099";
		RmiServerInterface remoteService = (RmiServerInterface) Naming.lookup(ip
				+ "/RmiService");
		RmiClient client = new RmiClient(remoteService);
		remoteService.registerForCallback(client);
		remoteService.addObserver(client);
		System.out.println(client.getID());
		ClientGUI gui = new ClientGUI(remoteService.getController(), getID(),remoteService, client);
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}

	public void update(Object observable, Object updateMsg)
			throws RemoteException {

	} 
	

	@Override
	public Order getOrders() {
		return order;
	}

	public void setOrder(Order order){
		this.order = order;
	}
	
	@Override
	public void callStaff() throws RemoteException {
		service.callStaff(ID);
		
	}

	@Override
	public void setID(int ID) {
		this.ID = ID;
		
	}

}