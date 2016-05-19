package Domain.Mediator;

import java.util.ArrayList;

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
	public Menu getMenuByType(String type) {
		return this.menu.showByType(type);
	}

	@Override
	public Menu showMenu() {
		return this.menu.show();
	}

	@Override
	public Menu showMeals() {
		return this.menu.showMeals();
	}

	@Override
	public Menu showDrinks() {
		return this.menu.showDrinks();
	}

	@Override
	public void addOrder(Order order) {
		this.orders.add(order);
	}

	@Override
	public void removeOrder(Order order) {
		this.orders.remove(order);
	}
	
	public void removePaid(){
		this.orders.remove();
	}

	@Override
	public ArrayList<Order> showOrders() {
		return this.orders.show();
	}

	
}