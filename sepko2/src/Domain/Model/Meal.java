package Domain.Model;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
public class Meal extends Item {
	private int amount;
	private String type;
	private boolean isPrepared;
	private boolean isServed;
	
	/**
	    * Constructor setting up name, description, price, amount, type and isServed boolean of a meal.
	    * @param name of the meal. 
	    * @param description of the meal. 
	    * @param price of the meal. 
	    * @param amount of the meal. 
	    * @param type of the meal. 
	    */
	public Meal(String name, String description, double price, int amount, String type) {
		super(name, description, price);
		this.amount = amount;
		this.type = type.toLowerCase();
		this.isPrepared = false;
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
	    * @param amount of a Meal
	    */	
	@Override
	public void setAmount(double amount) {
		this.amount = (int)amount;
	}
	
		/**
	    * toString method for drink.
	    * @return String
	    */
	public String toString(){
		
		if(isServed == false){
			return  (int)getAmount() + "g  " + super.getName() + " ---- " + super.getPrice()+"Kr." ; 
		}else{
			return  servedString();
		}
	}
	
		/**
	    * Method returning String containing more info about drink.
	    * @return String
	    */
	public String moreInfo(){
		return super.getName() + "\n" + super.getDescription() + "\n" + "Amount: " +
				(int)getAmount() + "g\n" + "Price: " + super.getPrice() + "Kr.";
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
		return  (int)getAmount() + "g  " + super.getName() + "---" + super.getPrice()+"Kr. - IS SERVED";
	}
}
