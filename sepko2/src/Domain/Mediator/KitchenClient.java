package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;

import Domain.Model.Item;
import Domain.Model.Order;
import View.KitchenGUI;

public class KitchenClient extends UnicastRemoteObject implements
		KitchenClientInterface, Serializable {

	private static final long serialVersionUID = 1L;
	private static RmiServerInterface remoteService;
	private static KitchenGUI gui;

		/**
	    * Constructor setting up RmiServerInterface.
	    * @param remoteService Variable containing the server interface.
	    */
	protected KitchenClient(RmiServerInterface remoteService)
			throws RemoteException {
		super();
		KitchenClient.remoteService = remoteService;
	}

		/**
	    * Main method, creating the connection with server, creating and starting kitchen GUI.
	    * @param args String parameter for the main.
	    * @throws Exception throws exception, or if method could not find gui class. 
	    */
	public static void main(String[] args) throws Exception {
		String ip = ReadIP.getReadIP("ServerIPaID").getIP();
		ip = "//" + ip + ":1099";
		remoteService = (RmiServerInterface) Naming.lookup(ip + "/RmiService");
		KitchenClient client = new KitchenClient(remoteService);
		remoteService.registerKitchenForCallBack(client);
		gui = new KitchenGUI(remoteService);
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}

		/**
	    * Method calling a method from KitchenGUI for updating the list with an order.
	    * @param order Order, which is added to the list on Kitchen side.
	    */
	@Override
	public void updateKitchen(Order order) {
		gui.updateKitchen(order);
	}
	
		/**
	    * Method calling a method from KitchenGUI for removing item from the list when the item is prepared.
	    * @param item Item, which is removed from the list of orders.
	    */
	public void updateKitchenRemoveItem(Item item) {
		gui.updateKitchenRemoveItem(item);
	}

}
