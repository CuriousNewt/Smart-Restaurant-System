package Domain.Model;

import java.util.ArrayList;

public class OrderList {
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
	
	
	
	public String show(){
		String s = "";
		int  next = 1;
		for(int i = 0; i < orders.size(); i++){
			s+= "ORDER " + next + " for TABLE " + orders.get(i).getTable()
					+ "\n" + orders.get(i).show() + "\n"
					+ "--------------------------------------------------------------------" + "\n";
		}
		return s;
	}
}
