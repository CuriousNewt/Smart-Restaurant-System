package Domain.Mediator;

import Domain.Model.Menu;
import Domain.Model.OrderList;

public class ModelManager implements RestaurantManager {
	
	private Menu menu;
	
	public ModelManager() {
		this.menu = new Menu();
	}
	
	public Menu getMenu() {
		return this.menu;
	}

	@Override
	public OrderList getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMeal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDrink() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMenuByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showMeals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showDrinks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder() {
		// TODO Auto-generated method stub
		
	}
}