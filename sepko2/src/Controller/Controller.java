package Controller;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.Serializable;
import java.util.ArrayList;

import Domain.Mediator.ModelManager;
import Domain.Model.Item;
import Domain.Model.Menu;
import Domain.Model.Table;
import Domain.Model.TableList;

public class Controller implements Serializable {
	private ModelManager manager;
	
		/**
	    * Constructor setting up ModelManager.
	    * @param manager ModelManager, which is setting the local variable manager.
	    */
	public Controller(ModelManager manager){
		this.manager = manager;
	}
	
		/**
	    * Calls one of the methods for getting a type of menu from manager based on the String parameter.
	    * @param what String, which is determines the type of menu.
	    * @return Method is returning Menu of selected type.
	    */
	public Menu show(String what){
		what = what.toLowerCase();
		switch(what){
		case "menu": return manager.showMenu();
		case "drinks": return manager.showDrinks();
		case "meals": return manager.showMeals();
		default: return null;
		}
	}
	
		/**
	    * Calls method from manager, which is creating new updated menu from the database.
	    */
	public void clearMenu() {
		manager.clearMenu();
	}
	
		/**
	    * Calls method from manager, which is returning list of tables.
	    * @return Method is returning TableList containing tables(clients).
	    */
	public TableList getTables() {
		return manager.getTables();
	}
	
		/**
	    * Calls method from manager, which is adding meal to the menu.
	    * @param name Name of the meal.
	    * @param description Description of the meal.
	    * @param price Price of the meal.
	    * @param amount Amount of the meal.
	    * @param type Type of the meal.
	    */

	public void addMeal(String name, String description, double price,
			int amount, String type) {
		this.manager.addMeal(name, description, price, amount, type);
	}

		/**
	    * Calls method from manager, which is adding drink to the menu.
	    * @param name Name of the drink.
	    * @param description Description of the drink.
	    * @param price Price of the drink.
	    * @param amount Amount of the drink.
	    * @param type Type of the drink.
	    */
	public void addDrink(String name, String description, double price,
			double amount, String type) {
		this.manager.addDrink(name, description, price, amount, type);
	}

	
		/**
	    * Calls method from manager, which is adding item from the menu to the order.
	    * @param item Item to move.
	    * @param tableNumber Number of the table, which is making order.
	    */
	public void addItemToOrder(Item item, int tableNumber) {
		this.manager.addItemToOrder(item, tableNumber);
	}

		/**
	    * Calls method from manager, which is deleting the item from the order.
	    * @param item Item to move.
	    * @param tableNumber Number of the table, which is making order.
	    */
	public void removeItemFromOrder(Item item, int tableNumber) {
		this.manager.removeItemFromOrder(item, tableNumber);
	}
		
		/**
	    * Calls method from manager which is removing an item when the order is paid.
	    * @param item Item to move.
	    * @param tableNumber Number of the table, which is making order.
	    */
	public void removePaid(int tableNumber, Item item){
		this.manager.removePaid(tableNumber, item);
	}

		/**
	    * Calls method from manager, which is showing orders on specific table.
	    * @param tableNumber Number of the table, which is making order.
	    * @return ArrayList Returns ArrayList of items in the order.
	    */
	public ArrayList<Item> showOrders(int tableNumber) {
		return this.manager.showOrder(tableNumber);
	}
	
		/**
	    * Calls method from manager, which is adding table to the TableList.
	    * @param table Table, which is adding to the TableList.
	    */
	public void addTable(Table table){
		manager.addTable(table);
	}

		/**
	    * Calls method from manager, which is returning itself (manager).
	    * @return manager Returns manager.
	    */
	public ModelManager getManager(){
		return manager;
	}
}
