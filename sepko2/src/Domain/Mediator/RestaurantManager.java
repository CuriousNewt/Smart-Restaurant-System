package Domain.Mediator;

import java.util.ArrayList;

import Domain.Model.*;

public interface RestaurantManager {
	Menu getMenu();

	TableList getTables();

	void addMeal(String name, String description, double price, int amount, String type);

	void addDrink(String name, String description, double price, double amount, String type);

	Menu getMenuByType(String type);

	Menu showMenu();

	Menu showMeals();

	Menu showDrinks();
	
	void removePaid(int tableNumber, Item item);

	ArrayList<Item> showOrder(int tableNumber);

	void addItemToOrder(Item item, int tableNumber);

	void removeItemFromOrder(Item item, int tableNumber);
	
	boolean isDuplicate(Item item);
	
	void clearPastOrders();
}
