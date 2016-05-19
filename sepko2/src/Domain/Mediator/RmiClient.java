package Domain.Mediator;

import java.io.FileNotFoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JFrame;
import Utility.RemoteObserver;
import Utility.RmiService;
import View.ClientGUI;

public class RmiClient extends UnicastRemoteObject implements RemoteObserver  {
	
	private int id;
	private static final long serialVersionUID = 1L;
	
	protected RmiClient() throws RemoteException, FileNotFoundException {
		super();
		this.id = ReadIP.getReadIP("ServerIPaID").getID();
	}
	
	public int getID(){
		return id;
	}

	public static void main(String[] args) throws Exception {
		
		
		try {
			String ip = ReadIP.getReadIP("ServerIPaID").getIP();
			ip = "//localhost"/* + ip*/ + ":1099";
			RmiService remoteService = (RmiService) Naming.lookup(ip
					+ "/RmiService");

			RmiClient client = new RmiClient();
			remoteService.addObserver(client);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		ClientGUI gui = new ClientGUI();
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}

	public void update(Object observable, Object updateMsg)
			throws RemoteException {
		
	}

	
}