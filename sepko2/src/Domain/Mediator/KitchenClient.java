package Domain.Mediator;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;

import Domain.Model.Order;
import Utility.RmiServerInterface;
import View.KitchenGUI;

public class KitchenClient  extends UnicastRemoteObject implements
KitchenClientInterface, Serializable {
	
	private static final long serialVersionUID = 1L;
	private static RmiServerInterface remoteService; 
	private static KitchenGUI gui;
	
	protected KitchenClient(RmiServerInterface remoteService) throws RemoteException {
		super();
		this.remoteService = remoteService;
	}
	public static void main(String[] args) throws Exception {
		String ip = ReadIP.getReadIP("ServerIPaID").getIP();
		ip = "//" + ip + ":1099";
		remoteService = (RmiServerInterface) Naming
				.lookup(ip + "/RmiService");
		KitchenClient client = new KitchenClient(remoteService);
		remoteService.registerKitchenForCallBack(client);
		gui = new KitchenGUI(remoteService, remoteService.getController());
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}
	@Override
	public void updateKitchen(Order order) {
		gui.updateKitchen(order);
		
	}

}
