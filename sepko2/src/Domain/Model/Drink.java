package Domain.Model;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
public class Drink extends Item {
	private double amount;
	private String type;
	private boolean isServed;
	
		/**
	    * Constructor setting up name, description, price, amount, type and isServed boolean of a drink.
	    * @param name of the drink. 
	    * @param description of the drink. 
	    * @param price of the drink. 
	    * @param amount of the drink. 
	    * @param type of the drink. 
	    */
	public Drink(String name, String description, double price, double amount, String type) {
		super(name, description, price);
		this.amount = amount;
		this.type = type;
		this.isServed = false;
	}

	
		/**
	    * Method returning amount variable.
	    * @return double
	    */
	@Override
	public double getAmount() {
		return amount;
	}
		
		/**
	    * Method setting amount variable.
	    * @param amount of a Drink
	    */	
	@Override
	public void setAmount(double amount) {
		this.amount = amount;
	}

		/**
	    * toString method for drink.
	    * @return String
	    */
	public String toString(){
		
		if(isServed == false){
			return getAmount() + "l  " + super.getName() + " ---- " + super.getPrice()+"Kr.";
		}else{
			return servedString();
		}
	}
	
		/**
	    * Method returning String containing more info about drink.
	    * @return String
	    */
	public String moreInfo(){
		return super.getName() + "\n" + super.getDescription() + "\n" + "Amount: " +
				getAmount() + "l\n" + "Price: " + super.getPrice() + "Kr.";
	}

		/**
	    * Method returning type variable.
	    * @return String
	    */
	@Override
	public String getType() {
		return type;
	}

		/**
	    * Method isServed variable on true.
	    */
	public void setAsServed(){
		isServed = true;
	}
	
		/**
	    * Method returning isServed variable.
	    * @return boolean True or false
	    */
	public boolean isServed(){
		return isServed;
	}
	
	
		/**
	    * Method returning toString with served part.
	    * @return String
	    */
	public String servedString(){
		return getAmount() + "l  " + super.getName() + "-- " + super.getDescription() + "---- " + super.getPrice()+"Kr. -- IS SERVED";
	}



}
