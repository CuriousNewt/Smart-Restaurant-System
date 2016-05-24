package Utility;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Controller.Controller;
import Domain.Mediator.ClientInterface;
import Domain.Model.Menu;
import Domain.Model.Order;

public interface RmiServerInterface extends Remote {

    void addObserver(RemoteObserver o) throws RemoteException;

    Menu show(String what) throws RemoteException;
    Controller getController() throws RemoteException;
    ArrayList<Order> showOrders() throws RemoteException;
    void registerForCallback(ClientInterface clientInterface) throws RemoteException;
    void doCallbacks(int ID) throws RemoteException;
}