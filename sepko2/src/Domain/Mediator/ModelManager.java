package Domain.Mediator;

import Domain.Model.*;

public class ModelManager implements RestaurantManager {
	
	private Menu menu;
	private OrderList orders;
	
	public ModelManager() {
		this.menu = new Menu();
		this.orders = new OrderList();
	}
	
	public Menu getMenu() {
		return this.menu;
	}

	@Override
	public OrderList getOrders() {
		return this.orders;
	}

	@Override
	public void addMeal(String name, String description, double price,
			int amount, String type) {
		this.menu.addMeal(name, description, price, amount, type);
	}

	@Override
	public void addDrink(String name, String description, double price,
			double amount, String type) {
		this.menu.addDrink(name, description, price, amount, type);
	}

	@Override
	public String getMenuByType(String type) {
		return this.menu.showByType(type);
	}

	@Override
	public String showMenu() {
		return this.menu.show();
	}

	@Override
	public String showMeals() {
		return this.menu.showMeals();
	}

	@Override
	public String showDrinks() {
		return this.menu.showDrinks();
	}

	@Override
	public void addOrder(Order order) {
		this.orders.add(order);
	}

	@Override
	public void removeOrder(Order order) {
		this.orders.remove();
	}
	
	public void removePaid(){
		this.orders.remove();
	}

	@Override
	public String showOrders() {
		return this.orders.show();
	}

	
}