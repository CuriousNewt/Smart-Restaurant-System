package Domain.Model;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
	private ArrayList<Item> items;
	private boolean paid;
	
	public Order(){
		this.paid = false;
		items = new ArrayList<>();
	}
	
	public int size(){
		return items.size();
	}
	
	public void addItem(Item item){
			items.add(item);
		}
	
	public Item getItem(int index){
		return items.get(index);
	}
	
	public void removeItem(Item item){
		items.remove(item);
	}
	
	public void pay(){
		this.paid = true;
	}
	
	public boolean isPaid(){
		return paid;
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
