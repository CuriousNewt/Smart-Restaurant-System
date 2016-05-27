package Domain.Model;

import java.io.Serializable;

public abstract class Item implements Serializable{
	private String name;
	private String description;
	private double price;
	private boolean isServed;
	private boolean isPrepared;
	
	public Item(String name, String description, double price){
		this.name = name;
		this.description = description;
		this.price = price;
		this.isServed = false;
		this.isPrepared = false;
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
	
	public void setAsServed(){
		this.isServed = true;
	}
	
	public boolean isServed(){
		return isServed;
	}
	
	public void setAsPrepared(){
		this.isPrepared = false;
	}
	public abstract double getAmount();

	public abstract void setAmount(double amount);

	public abstract String getType();
	
	public abstract String toString();
	
	public abstract String moreInfo();

	public boolean isPrepared() {
		return isPrepared;
	}
	
	public boolean equals(Item item){
		return item.name.equals(this.name) && item.price == this.price;
	}
}
