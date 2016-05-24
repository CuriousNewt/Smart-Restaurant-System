package Domain.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderList implements Serializable {
	private ArrayList<Order> orders;
	
	public OrderList(){
		orders = new ArrayList<>();
	}
	
	public void add(Order order){
		orders.add(order);
	}
	
	public void remove(){
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).isPaid())
				orders.remove(i);
		}
	}
	
	public void remove(Order order){
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).equals(order))
				orders.remove(i);
		}
	}
	
	public ArrayList<Order> show(){
		return orders;
	}

	public int size() {
		return orders.size();
	}
}
