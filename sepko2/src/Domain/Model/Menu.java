package Domain.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {
	private ArrayList<Item> items;

	public Menu() {
		items = new ArrayList<>();
	}

	public Item get(int index) {
		return items.get(index);
	}

	public int size() {
		return items.size();
	}

	public void add(Item item) {
		items.add(item);
	}

	public void addMeal(String name, String description, double price,
			int amount, String type) {
		Item meal = new Meal(name, description, price, amount, type);
		items.add(meal);
	}

	public void addDrink(String name, String description, double price,
			double amount, String type) {
		Item drink = new Drink(name, description, price, amount, type);
		items.add(drink);
	}

	public Menu showByType(String type) {
		Menu s = new Menu();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getType().equals(type))
				s.add(items.get(i));
		}
		return s;
	}

	public Menu showMeals() {
		Menu s = new Menu();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Meal)
				s.add(items.get(i));
		}
		return s;
	}

	public Menu showDrinks() {
		Menu s = new Menu();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Drink)
				s.add(items.get(i));
		}
		return s;
	}

	public Menu show() {
		Menu s = new Menu();
		for (int i = 0; i < items.size(); i++) {
			s.add(items.get(i));
		}
		return s;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < items.size(); i++) {
			s += (i + 1) + "/" + items.get(i).toString();
		}
		return s;
	}
}
