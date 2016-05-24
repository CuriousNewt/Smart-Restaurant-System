package Domain.Mediator;

import java.io.Serializable;
import java.util.ArrayList;

import Domain.Model.*;

public class ModelManager implements RestaurantManager, Serializable {
	
	private Menu menu;
	private TableList tables;
	
	public ModelManager() {
		this.menu = new Menu();
		this.tables = new TableList();
	}
	
	public Menu getMenu() {
		return this.menu;
	}

	@Override
	public TableList getTables() {
		return this.tables;
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
	public void addItemToOrder(Item item, int tableNumber) {
		this.tables.getTable(tableNumber).addItemToOrder(item);
	}

	@Override
	public void removeItemFromOrder(Item item, int tableNumber) {
		this.tables.getTable(tableNumber).removeItem(item);
	}
	//TODO remove all the items (forloop)
	public void removePaid(int tableNumber, Item item){
		this.tables.getTable(tableNumber).removeItem(item);
	}

	@Override
	public ArrayList<Item> showOrder(int tableNumber) {
		ArrayList<Item> temp = new ArrayList<Item>();
		for(int i = 0; i < tables.getTable(tableNumber).getOrder().size(); i++){
			temp.add(tables.getTable(tableNumber).getOrder().getItem(i));
		}
		return temp;
	}
	
	public void addTable(Table table){
		tables.addTable(table);
	}

	
}