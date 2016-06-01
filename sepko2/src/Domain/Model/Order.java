package Domain.Model;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
	private ArrayList<Item> items;
	private boolean paid;
	
	
	
		/**
	    * Constructor setting up paid boolean on false, and creating new ArrayList of Items.
	    */
	public Order(){
		this.paid = false;
		items = new ArrayList<>();
	}
	
		/**
	    * Method returning size of ArrayList.
	    * @return int size
	    */
	public int size(){
		return items.size();
	}
	
	
		/**
	    * Method for adding an item to the ArrayList. 
	    * @param item to add
	    */
	public void addItem(Item item){
			items.add(item);
		}
	
		/**
	    * Method for getting an item from the ArrayList.
	    * @param index of an Item
	    * @return Item
	    */
	public Item getItem(int index){
		return items.get(index);
	}
	
	
		/**
	    * Method for removing and item from the ArrayList.
	    * @param item to remove
	    */
	public void removeItem(Item item){
		items.remove(item);
	}
	
	
		/**
	    * Method setting paid boolean on true.
	    */
	public void pay(){
		this.paid = true;
	}
	
		/**
	    * Method returning boolean paid.
	    * @return paid boolean
	    */
	public boolean isPaid(){
		return paid;
	}
	
		/**
	    * Method returning summary price of items in the order.
	    * @return double Summary price
	    */
	public double getPrice(){
		double price = 0;
		for (int i = 0; i < items.size(); i++) {
			price += items.get(i).getPrice();
		}
		return price;
	}
	
	
		/**
	    * Method returning the string of items in the order.
	    * @return String of items. 
	    */
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
