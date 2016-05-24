package Domain.Model;

import java.util.ArrayList;

public class Order { 
	private ArrayList<Item> items;
	private boolean served;
	private boolean paid;
	
	public Order(){
		this.served = false;
		this.paid = false;
		items = new ArrayList<>();
	}
	
	public void addItem(Item item){
			items.add(item);
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
