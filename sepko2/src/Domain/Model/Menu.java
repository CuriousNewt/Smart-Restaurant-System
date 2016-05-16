package Domain.Model;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Item> items;
	
	public Menu(){
		items = new ArrayList<>();
	}
	
	public void addMeal(String name, String description, double price, int amount, String type){
		Item meal = new Meal(name, description, price, amount, type);
		items.add(meal);
	}
	
	public void addDrink(String name, String description, double price, double amount, String type){
		Item drink = new Drink(name, description, price, amount, type);
		items.add(drink);
	}
	
	public String showByType(String type){
		String s = "";
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getType().equals(type))
				s+= items.get(i).toString();
		}
		return s;
	}
	
	public String showMeals(){
		String s = "";
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i) instanceof Meal)
				s+= items.get(i).toString();
		}
		return s;
	}
	
	public  String showDrinks(){
		String s = "";
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i) instanceof Drink)
				s+= items.get(i).toString();
		}
		return s;
	}
	
	public String show(){
		String s = "";
		for (int i = 0; i < items.size(); i++) {
			s+= (i+1) + "/ " + items.get(i).toString();
		}
		return s;
	}
}
