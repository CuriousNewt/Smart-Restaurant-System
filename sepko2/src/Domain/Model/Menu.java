package Domain.Model;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {
	private ArrayList<Item> items;

		/**
	    * Constructor setting up new ArrayList of items.
	    */
	public Menu() {
		items = new ArrayList<>();
	}

		/**
	    * Method returning item from ArrayList of Items.
	    * @param index to get
	    * @return Item
	    */
	public Item get(int index) {
		return items.get(index);
	}

		/**
	    * Method returning the size of the items ArrayList.
	    * @return int 
	    */
	public int size() {
		return items.size();
	}

		/**
	    * Method adding item to the items ArrayList.
	    * @param item to add
	    */
	
	public void add(Item item) {
		items.add(item);
	}

		/**
	    * Method adding drink to the menu.
	    * @param name of the meal. 
	    * @param description of the meal. 
	    * @param price of the meal. 
	    * @param amount of the meal. 
	    * @param type of the meal. 
	    */
	public void addMeal(String name, String description, double price,
			int amount, String type) {
		Item meal = new Meal(name, description, price, amount, type);
		items.add(meal);
	}

		/**
	    * Method adding drink to the menu.
	    * @param name of the drink. 
	    * @param description of the drink. 
	    * @param price of the drink. 
	    * @param amount of the drink. 
	    * @param type of the drink. 
	    */
	public void addDrink(String name, String description, double price,
			double amount, String type) {
		Item drink = new Drink(name, description, price, amount, type);
		items.add(drink);
	}

	
		/**
	    * Method filling up Menu object with items of selected type and returning it.
	    * @param type to show
	    * @return Menu
	    */
	public Menu showByType(String type) {
		Menu s = new Menu();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getType().equals(type))
				s.add(items.get(i));
		}
		return s;
	}

	
		/**
	    * Method filling up Menu object with meal items and returning it.
	    * @return Menu
	    */
	public Menu showMeals() {
		Menu s = new Menu();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Meal)
				s.add(items.get(i));
		}
		return s;
	}

		/**
	    * Method filling up Menu object with drink items and returning it.
	    * @return Menu
	    */
	public Menu showDrinks() {
		Menu s = new Menu();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Drink)
				s.add(items.get(i));
		}
		return s;
	}

		/**
	    * Method filling up Menu object with items and returning it.
	    * @return Menu
	    */
	public Menu show() {
		Menu s = new Menu();
		for (int i = 0; i < items.size(); i++) {
			s.add(items.get(i));
		}
		return s;
	}

	
		/**
	    * toString method for drink.
	    * @return String
	    */
	public String toString() {
		String s = "";
		for (int i = 0; i < items.size(); i++) {
			s += (i + 1) + "/" + items.get(i).toString();
		}
		return s;
	}
}
