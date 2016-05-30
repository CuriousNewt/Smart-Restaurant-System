package Domain.Model;

import java.io.Serializable;

public abstract class Item implements Serializable{
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
	
	public abstract void setAsServed();
	
	public abstract boolean isServed();
	
	public abstract void setAsPrepared();
	
	public abstract double getAmount();

	public abstract void setAmount(double amount);

	public abstract String getType();
	
	public abstract String toString();
	
	public abstract String moreInfo();

	public abstract boolean isPrepared();
	
	public boolean equals(Item item){
		return item.name.equals(this.name) && item.price == this.price;
	}
}
