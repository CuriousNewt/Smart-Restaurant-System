package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.Serializable;
import java.util.ArrayList;

import Domain.Model.*;

public class ModelManager implements RestaurantManager, Serializable {
	
	private Menu menu;
	private TableList tables;
	private ArrayList<String> pastOrdersArrayList;
	
	
		/**
	    * Constructor setting up TableList, Menu and ArrayList of past orders.
	    */
	public ModelManager() {
		this.menu = new Menu();
		this.tables = new TableList();
		pastOrdersArrayList = new ArrayList<String>();
	}
	
	
		/**
	    * Method for returning menu object.
	    * @return menu object.
	    */
	public Menu getMenu() {
		return this.menu;
	}
	
		/**
	    * Method for creating new empty menu object.
	    */
	public void clearMenu() {
		this.menu = new Menu();
	}
	
	
		/**
	    * Method for returning ArrayList of tables.
	    * @return ArrayList of tables.
	    */
	@Override
	public TableList getTables() {
		return this.tables;
	}

	
		/**
	    * Method calling method from menu for adding a meal.
	    * @param name Name of the meal.
	    * @param description Description of the meal.
	    * @param price Price of the meal.
	    * @param amount Amount of the meal.
	    * @param type Type of the meal.
	    */
	@Override
	public void addMeal(String name, String description, double price,
			int amount, String type) {
		this.menu.addMeal(name, description, price, amount, type);
	}

		/**
	 	* Method calling method from menu for adding a drink.
	    * @param name Name of the drink.
	    * @param description Description of the drink.
	    * @param price Price of the drink.
	    * @param amount Amount of the drink.
	    * @param type Type of the drink.
	    */
	@Override
	public void addDrink(String name, String description, double price,
			double amount, String type) {
		this.menu.addDrink(name, description, price, amount, type);
	}

	
	/**
 	* Method calling method from menu for showing menu by selected type.
    * @param type String setting up selected type.
    * @return Menu object of selected type of food.
    */
	@Override
	public Menu getMenuByType(String type) {
		return this.menu.showByType(type);
	}

	
	/**
 	* Method calling method from menu for showing menu.
    * @return Menu object.
    */	
	@Override
	public Menu showMenu() {
		return this.menu.show();
	}

	
	/**
 	* Method calling method from menu for showing menu of the meals.
    * @return Menu object filled up with drinks.
    */
	@Override
	public Menu showMeals() {
		return this.menu.showMeals();
	}

	
	/**
 	* Method calling method from menu for showing menu of the drink.
    * @return Menu object filled up with drinks.
    */
	@Override
	public Menu showDrinks() {
		return this.menu.showDrinks();
	}
	

	/**
 	* Method calling method from tables for getting a table and then adding item to the order.
    * @param item Item added to the order.
    * @param tableNumber which is adding item to the order.
    */
	@Override
	public void addItemToOrder(Item item, int tableNumber) {
		this.tables.getTable(tableNumber).addItemToOrder(item);
	}

	/**
 	* Method calling method from tables for getting a table and then removing item from the order.
    * @param item Item removed from the order.
    * @param tableNumber which wants to remove the item from the order.
    */
	@Override
	public void removeItemFromOrder(Item item, int tableNumber) {
		this.tables.getTable(tableNumber).removeItem(item);
	}

	/**
 	* Method calling method from tables for getting a table and then removing the item from the table.
    * @param item Item removed from the order.
    * @param tableNumber which paid the order.
    */
	public void removePaid(int tableNumber, Item item){
		this.tables.getTable(tableNumber).removeItem(item);
	}

	
	/**
 	* Method calling method from tables for getting a table and then getting order from the table.
    * @param tableNumber Number of the table.
    * @return ArrayList of all items in the order.
    */
	@Override
	public ArrayList<Item> showOrder(int tableNumber) {
		ArrayList<Item> temp = new ArrayList<Item>();
		for(int i = 0; i < tables.getTable(tableNumber).getOrder().size(); i++){
			temp.add(tables.getTable(tableNumber).getOrder().getItem(i));
		}
		return temp;
	}
	
	
	/**
 	* Method calling method from tables for adding a table.
    * @param table added to the Tables.
    */
	public void addTable(Table table){
		tables.addTable(table);
	}

	
	/**
 	* Method returning ArrayList of past orders.
    * @return ArrayList of past orders.
    */
	public ArrayList<String> getPastOrders() {
		return pastOrdersArrayList;
	}

	/**
 	* Method checking if item is already exists in the menu.
    * @param item Item to compare.
    * @return boolean True or False.
    */
	@Override
	public boolean isDuplicate(Item item) {
		for(int i = 0; i < menu.size(); i++) {
			if(menu.get(i).equals(item)) {
				return true;
			}
		}
		return false;
	}


	/**
	* Method for creating new empty ArrayList of past orders.
	*/
	public void clearPastOrders() {
		pastOrdersArrayList = new ArrayList<String>();
	}

}
