package Utility;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Controller.Controller;
import Domain.Mediator.ClientInterface;
import Domain.Mediator.KitchenClientInterface;
import Domain.Model.Item;
import Domain.Model.Menu;
import Domain.Model.Order;

public interface RmiServerInterface extends Remote{

    Menu show(String what) throws RemoteException;
    Controller getController() throws RemoteException;
    ArrayList<Item> showOrders(int tableNumber) throws RemoteException;
    void registerForCallback(ClientInterface clientInterface) throws RemoteException;
    void doCallbacks(int ID) throws RemoteException;
    void updateMenuOfClients() throws RemoteException;
	void callStaff(int ID) throws RemoteException;
	void colourBackground(int ID) throws RemoteException;
	void registerKitchenForCallBack(KitchenClientInterface kitchenInterface) throws RemoteException;
	void updateKitchen(Order order) throws RemoteException;
}