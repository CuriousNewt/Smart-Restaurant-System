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
import Utility.RmiService;
import View.ClientGUI;

public class RmiClient extends UnicastRemoteObject implements RemoteObserver,
		Serializable {

	private int id;
	private static final long serialVersionUID = 1L;
	private RmiService service;

	protected RmiClient(RmiService service) throws RemoteException,
			FileNotFoundException {
		super();
		this.id = ReadIP.getReadIP("ServerIPaID").getID();
		this.service = service;

	}

	public int getID() {
		return id;
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
		RmiService remoteService = (RmiService) Naming.lookup(ip
				+ "/RmiService");

		RmiClient client = new RmiClient(remoteService);
		remoteService.addObserver(client);
		// System.out.println(client.get("menu"));
		ClientGUI gui = new ClientGUI(remoteService.getController());
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}

	public void update(Object observable, Object updateMsg)
			throws RemoteException {

	}

}