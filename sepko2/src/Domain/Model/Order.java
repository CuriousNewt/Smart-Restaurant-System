package Domain.Model;

import java.util.ArrayList;

public class Order { 
	private ArrayList<Item> items;
	private int table;
	private boolean served;
	private boolean paid;
	
	public Order(int table){
		this.table = table;
		this.served = false;
		this.paid = false;
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
	
	public void pay(){
		this.paid = true;
	}
	
	public void serve(){
		this.served = true;
	}
	
	public boolean isPaid(){
		return paid;
	}
	
	public boolean isServed(){
		return served;
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
		int next = 1;
		for(int i = 0; i < items.size(); i++){
			s+= "ITEM " + next + ": " + items.get(i).getName() + " AMOUNT: " + items.get(i).getAmount();
			next++;
		}
		return s;
	}
}
