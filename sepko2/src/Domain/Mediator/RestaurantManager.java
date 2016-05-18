package Domain.Mediator;

import Domain.Model.*;

public interface RestaurantManager {
	Menu getMenu();

	OrderList getOrders();

	void addMeal(String name, String description, double price, int amount, String type);

	void addDrink(String name, String description, double price, double amount, String type);

	String getMenuByType(String type);

	String showMenu();

	String showMeals();

	String showDrinks();

	void addOrder(Order order);

	void removeOrder(Order order);
	
	void removePaid();

	String showOrders();
}
