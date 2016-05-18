package Domain.Mediator;

import Domain.Model.*;

public interface RestaurantManager {
	Menu getMenu();

	OrderList getOrders();

	void addMeal();

	void addDrink();

	String getMenuByType(String type);

	String showMenu();

	String showMeals();

	String showDrinks();

	void addOrder();

	void removeOrder();

	String showOrders();
}
