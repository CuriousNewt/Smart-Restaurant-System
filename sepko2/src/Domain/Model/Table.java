package Domain.Model;

import java.util.ArrayList;

public class Table {
	private Order order;
	private int tableNumber;

	
	
	public Table(int tableNumber){
		this.tableNumber = tableNumber;
		this.order = new Order();
	}
	
	public String toString(){
		return "Table number " + tableNumber;
	}
	
	public void addItemToOrder(Item item){
		this.order.addItem(item);
	}
	
	public void removeItem(Item item){
		this.order.removeItem(item);
	}
	
	public Order getOrder(){
		return order;
	}
}
