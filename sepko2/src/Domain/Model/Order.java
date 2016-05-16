package Domain.Model;

import java.util.ArrayList;

public class Order {
	private ArrayList<Item> items;
	private int table;
	
	public Order(int table){
		this.table = table;
		items = new ArrayList<>();
	}
	
	public void addItem(Item item, int quantity){
		for (int i = 0; i < quantity; i++) {
			items.add(item);
		}
		
		}
	
	public void removeItem(Item item){
		items.remove(item);
	}
	
	public double getPrice(){
		double price = 0;
		for (int i = 0; i < items.size(); i++) {
			price += items.get(i).getPrice();
		}
		return price;
	}
	
	public int getTable(){
		return table;
	}
	
	public String show(){
		String s = "";
		for(int i = 0; i < items.size(); i++){
			s+= items.get(i).toString();
		}
		return s;
	}
}
