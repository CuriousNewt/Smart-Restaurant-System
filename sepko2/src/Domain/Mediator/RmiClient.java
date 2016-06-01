package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;

import Controller.Controller;
import Domain.Model.*;
import View.ClientGUI;

public class RmiClient extends UnicastRemoteObject implements ClientInterface, Serializable {
	
	private static int ID;
	private static final long serialVersionUID = 1L;
	private RmiServerInterface service;
	private Order order;
	private static ClientGUI gui;
	private static RmiServerInterface remoteService; 

		/**
	    * Constructor setting up RmiServerInterface.
	    * @param service RmiServerInterface, which is setting the local object variable service.
	    */
	protected RmiClient(RmiServerInterface service) throws RemoteException,
			FileNotFoundException {
		super();
		this.service = service;
	}

	/**
	* Method for setting up ID variable on client from server through RMI connection.
	* @return int ID of client.
	*/
	public static int getID() {
		return ID;
	}

	/**
	* Method for getting Menu from server to the client through RMI connection.
	* @throws RemoteException When RMI connection between server and client is not working.
	* @return Menu from server.
	*/
	public Menu getMenu() throws RemoteException {
		return this.service.show("menu");
	}

	/**
	* Method for getting specific Menu from server to the client through RMI connection.
	* @param what String, which specifies the type of menu.
	* @throws RemoteException When RMI connection between server and client is not working.
	* @return Menu specific type of menu.
	*/
	public Menu get(String what) throws RemoteException {
		return this.service.show(what);
	}

	/**
	* Method for getting Controller from server to the client through RMI connection.
	* @throws RemoteException When RMI connection between server and client is not working.
	* @return Controller
	*/
	public Controller getController() throws RemoteException {
		return this.service.getController();
	}

	public static void main(String[] args) throws Exception {
		String ip = ReadIP.getReadIP("ServerIPaID").getIP();
		ip = "//" + ip + ":1099";
		remoteService = (RmiServerInterface) Naming
				.lookup(ip + "/RmiService");
		RmiClient client = new RmiClient(remoteService);
		remoteService.registerForCallback(client);
		gui = new ClientGUI(remoteService.getController(), getID(),remoteService, client);
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}

	/**
	* Method for getting an order from client to server through RMI connection.
	* @return Order Order of items ordered by client.
	*/
	@Override
	public Order getOrder() {
		return order;
	}

	/**
	* Method for setting order object.
	* @param order Order object.
	*/
	public void setOrder(Order order){
		this.order = order;
	}
	
	
	/**
	* Method for giving confirmation from server through RMI connection if the staff is called.
	* @throws RemoteException When RMI connection between server and client is not working.
	*/
	@Override
	public void callStaff() throws RemoteException {
		service.callStaff(ID);
	}

	
	/**
	* Method for setting up ID variable on client from server through RMI connection.
	* @param ID Integer, declaring what ID will the client have.
	*/
	@Override
	public void setID(int ID) {
		RmiClient.ID = ID;
	}
	
	/**
	* Method for updating menu from server on client through the RMI connection.
	*/
	public void updateMenu() {
		try {
			gui.setController(remoteService.getController());
			gui.getMenuByType();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	
	/**
	* Method for getting ID from client to server through the RMI connection.
	* @throws RemoteException When RMI connection between server and client is not working.
	* @return int ID of the client.
	*/
	@Override
	public int getIDForKitchen() throws RemoteException {
		return ID;
	}


}