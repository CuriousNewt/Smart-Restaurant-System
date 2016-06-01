package Domain.Model;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.Serializable;

public abstract class Item implements Serializable{
	private String name;
	private String description;
	private double price;
	
		/**
	    * Constructor setting up name, description, price of classes which extends Item class.
	    * @param name of the drink. 
	    * @param description of the drink. 
	    * @param price of the drink.
	    */	
	public Item(String name, String description, double price){
		this.name = name;
		this.description = description;
		this.price = price;
	}

		/**
	    * Method returning name variable.
	    * @return String
	    */
	public String getName() {
		return name;
	}

		/**
	    * Method returning description variable.
	    * @return String
	    */
	public String getDescription() {
		return description;
	}

		/**
	    * Method returning price variable.
	    * @return double
	    */
	public double getPrice() {
		return price;
	}

		/**
	    * Method setting up price variable.
	    * @param price of an Item
	    */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
		/**
	    * Abstract method setting isServed variable on true. 
	    */
	public abstract void setAsServed();
	
		/**
	    * Abstract method returning isServed variable.
	    * @return boolean
	    */
	public abstract boolean isServed();
	
		/**
	    * Abstract method returning amount variable.
	    * @return double
	    */
	public abstract double getAmount();

		/**
	    * Abstract method setting amount variable.
	    * @param amount amount of an Item
	    */
	public abstract void setAmount(double amount);

		/**
	    * Abstract method returning type String.
	    * @return String
	    */
	public abstract String getType();
	
		/**
	    * Abstract method returning toString.
	    * @return String
	    */
	public abstract String toString();
	
		/**
	    * Abstract method returning more info String .
	    * @return String
	    */
	public abstract String moreInfo();

}
