package Domain.Mediator;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;

import Utility.RemoteObserver;
import Utility.RmiServerInterface;
import View.ClientGUI;
import View.KitchenGUI;

public class KitchenClient extends UnicastRemoteObject implements RemoteObserver, Serializable, Runnable {
	private int ID;
	private static RmiServerInterface serverInterface;
	private static KitchenGUI gui;

	protected KitchenClient(RmiServerInterface serverInterface) throws RemoteException {
		super();
		this.ID = 666;
		this.serverInterface = serverInterface;
	}

	@Override
	public void update(Object observable, Object updateMsg)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while(true){
			try {
				gui.updateLists();
				Thread.sleep(15000);
			} catch (InterruptedException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		String ip = ReadIP.getReadIP("ServerIPaID").getIP();
		ip = "//" + ip + ":1099";
		serverInterface = (RmiServerInterface) Naming
				.lookup(ip + "/RmiService");
		KitchenClient client = new KitchenClient(serverInterface);
		gui = new KitchenGUI(serverInterface);
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
		Thread kitchen = new Thread();
		kitchen.start();
	}

}
