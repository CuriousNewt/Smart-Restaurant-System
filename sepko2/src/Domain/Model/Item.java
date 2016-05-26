package Domain.Model;

import java.io.Serializable;

public abstract class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private double price;
	
	public Item(String name, String description, double price){
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public abstract double getAmount();

	public abstract void setAmount(double amount);

	public abstract String getType();
	
	public abstract String toString();
	
	public abstract String moreInfo();
}
