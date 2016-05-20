package Controller;
import java.io.Serializable;
import java.util.ArrayList;

import Domain.Mediator.ModelManager;
import Domain.Model.Menu;
import Domain.Model.Order;
import Domain.Model.OrderList;

public class Controller implements Serializable {
	private ModelManager manager;
	
	public Controller(ModelManager manager){
		this.manager = manager;
	}
	
	public Menu showMenuByType(String type){
		return manager.getMenuByType(type);
	}
	
	public Menu show(String what){
		what = what.toLowerCase();
		switch(what){
		case "menu": return manager.showMenu();
		case "drinks": return manager.showDrinks();
		case "meals": return manager.showMeals();
		default: return null;
		}
	}
	
	public OrderList getOrders() {
		return manager.getOrders();
	}

	public void addMeal(String name, String description, double price,
			int amount, String type) {
		this.manager.addMeal(name, description, price, amount, type);
	}

	
	public void addDrink(String name, String description, double price,
			double amount, String type) {
		this.manager.addDrink(name, description, price, amount, type);
	}

	
	
	public void addOrder(Order order) {
		this.manager.addOrder(order);
	}

	
	public void removeOrder(Order order) {
		this.manager.removeOrder(order);
	}
	
	public void removePaid(){
		this.manager.removePaid();
	}

	
	public ArrayList<Order> showOrders() {
		return this.manager.showOrders();
	}

}
