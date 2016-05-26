package Controller;
import java.io.Serializable;
import java.util.ArrayList;

import Domain.Mediator.ModelManager;
import Domain.Model.Item;
import Domain.Model.Menu;
import Domain.Model.Table;
import Domain.Model.TableList;

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
	
	public void clearMenu() {
		manager.clearMenu();
	}
	
	public TableList getTables() {
		return manager.getTables();
	}

	public void addMeal(String name, String description, double price,
			int amount, String type) {
		this.manager.addMeal(name, description, price, amount, type);
	}

	
	public void addDrink(String name, String description, double price,
			double amount, String type) {
		this.manager.addDrink(name, description, price, amount, type);
	}

	
	
	public void addItemToOrder(Item item, int tableNumber) {
		this.manager.addItemToOrder(item, tableNumber);
	}

	
	public void removeItemFromOrder(Item item, int tableNumber) {
		this.manager.removeItemFromOrder(item, tableNumber);
	}
	
	public void removePaid(int tableNumber, Item item){
		this.manager.removePaid(tableNumber, item);
	}

	
	public ArrayList<Item> showOrders(int tableNumber) {
		return this.manager.showOrder(tableNumber);
	}
	
	public void addTable(Table table){
		manager.addTable(table);
	}

}
