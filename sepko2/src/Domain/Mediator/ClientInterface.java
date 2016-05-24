package Domain.Mediator;

import Domain.Model.Order;
import Utility.RmiServerInterface;

public interface ClientInterface {
	void setID(int ID);
	public Order getOrders();
	public void callStaff();
	
	
}
