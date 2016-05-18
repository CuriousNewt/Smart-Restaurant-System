package Domain.Mediator;

import Domain.Model.Menu;

public class ModelManager {
	
	private Menu menu;
	
	public ModelManager() {
		this.menu = new Menu();
	}
	
	public Menu getMenu() {
		return this.menu;
	}
}