package Utility;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Controller.Controller;
import Domain.Mediator.ClientInterface;
import Domain.Model.Item;
import Domain.Model.Menu;

public interface RmiServerInterface extends Remote {

    void addObserver(RemoteObserver o) throws RemoteException;

    Menu show(String what) throws RemoteException;
    Controller getController() throws RemoteException;
    ArrayList<Item> showOrders(int tableNumber) throws RemoteException;
    void registerForCallback(ClientInterface clientInterface) throws RemoteException;
    void doCallbacks(int ID) throws RemoteException;

	void callStaff(int ID) throws RemoteException;
}