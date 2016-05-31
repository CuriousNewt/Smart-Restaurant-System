package Domain.Model;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
public class Meal extends Item {
	private int amount;
	private String type;
	private boolean isPrepared;
	private boolean isServed;
	
	public Meal(String name, String description, double price, int amount, String type) {
		super(name, description, price);
		this.amount = amount;
		this.type = type.toLowerCase();
		this.isPrepared = false;
		this.isServed = false;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = (int)amount;
	}
	
	public String toString(){
		
		if(isServed == false){
			return  (int)getAmount() + "g  " + super.getName() + " ---- " + super.getPrice()+"Kr." ; 
		}else{
			return  servedString();
		}
	}
	
	public String moreInfo(){
		return super.getName() + "\n" + super.getDescription() + "\n" + "Amount: " +
				(int)getAmount() + "g\n" + "Price: " + super.getPrice() + "Kr.";
	}

	@Override
	public String getType() {
		return type;
	}
	
	public void setAsPrepared(){
		this.isPrepared = true;
	}
	public boolean isPrepared(){
		return isPrepared;
	}

	public void setAsServed(){
		isServed = true;
	}
	
	public boolean isServed(){
		return isServed;
	}

	public String servedString(){
		return  (int)getAmount() + "g  " + super.getName() + "---" + super.getPrice()+"Kr. - IS SERVED";
	}
}
