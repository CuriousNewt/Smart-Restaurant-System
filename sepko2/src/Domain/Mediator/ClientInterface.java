package Domain.Mediator;

import java.rmi.Remote;

import Domain.Model.Order;

public interface ClientInterface extends Remote {
	void setID(int ID);
	public Order getOrders();
	public void callStaff();
	
	
}
