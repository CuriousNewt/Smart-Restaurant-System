package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.rmi.RemoteException;
import java.util.ArrayList;

import Domain.Model.*;

public interface RestaurantManager {
	
	/**
	* ModelManager interface method for getting menu from server ModelManager.
	* @return Menu object.
	*/
	Menu getMenu();

	/**
	* ModelManager interface method for returning TableList.
	* @return TableList 
	*/
	TableList getTables();

	/**
	 * ModelManager interface method for adding a meal to the order on a table.
	 * @param name Name of the meal.
	 * @param description Description of the meal.
	 * @param price Price of the meal.
	 * @param amount Amount of the meal.
	 * @param type Type of the meal.
	 */
	void addMeal(String name, String description, double price, int amount, String type);

	/**
 	* ModelManager interface method calling method from menu for adding a drink to the order on a table.
    * @param name Name of the drink.
    * @param description Description of the drink.
    * @param price Price of the drink.
    * @param amount Amount of the drink.
    * @param type Type of the drink.
    */
	void addDrink(String name, String description, double price, double amount, String type);

	/**
 	* ModelManager interface method calling method from menu for showing menu by selected type.
    * @param type String setting up selected type.
    * @return Menu object of selected type of food.
    */
	Menu getMenuByType(String type);

	/**
 	* ModelManager interface method calling method from menu for showing menu.
    * @return Menu object.
    */	
	Menu showMenu();

	/**
 	* ModelManager interface method calling method from menu for showing menu of the meals.
    * @return Menu object filled up with drinks.
    */
	Menu showMeals();

	/**
 	* ModelManager interface method calling method from menu for showing menu of the drink.
    * @return Menu object filled up with drinks.
    */
	Menu showDrinks();
	
	/**
 	* ModelManager interface method calling method from tables for getting a table and then removing the item from the table.
    * @param item Item removed from the order.
    * @param tableNumber which paid the order.
    */
	void removePaid(int tableNumber, Item item);
	
	/**
 	* ModelManager interface method calling method from tables for getting a table and then getting order from the table.
    * @param tableNumber Number of the table.
    * @return ArrayList of all items in the order.
    */
	ArrayList<Item> showOrder(int tableNumber);

	/**
 	* ModelManager interface method calling method from tables for getting a table and then adding item to the order.
    * @param item Item added to the order.
    * @param tableNumber which is adding item to the order.
    */
	void addItemToOrder(Item item, int tableNumber);

	/**
 	* ModelManager interface method calling method from tables for getting a table and then removing item from the order.
    * @param item Item removed from the order.
    * @param tableNumber which wants to remove the item from the order.
    */
	void removeItemFromOrder(Item item, int tableNumber);
	
	
	/**
 	* ModelManager interface method checking if item is already exists in the menu.
    * @param item Item to compare.
    * @return boolean True or False.
    */
	boolean isDuplicate(Item item);
	
	/**
	* ModelManager interface method for creating new empty ArrayList of past orders.
	*/
	void clearPastOrders();
}
