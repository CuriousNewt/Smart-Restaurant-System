package Domain.Mediator;

import java.util.ArrayList;

import Domain.Model.*;

public interface RestaurantManager {
	Menu getMenu();

	OrderList getOrders();

	void addMeal(String name, String description, double price, int amount, String type);

	void addDrink(String name, String description, double price, double amount, String type);

	Menu getMenuByType(String type);

	Menu showMenu();

	Menu showMeals();

	Menu showDrinks();

	void addOrder(Order order);

	void removeOrder(Order order);
	
	void removePaid();

	ArrayList<Order> showOrders();
}
