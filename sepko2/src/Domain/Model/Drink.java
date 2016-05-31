package Domain.Model;

public class Drink extends Item {
	private double amount;
	private String type;
	private boolean isServed;
	
	public Drink(String name, String description, double price, double amount, String type) {
		super(name, description, price);
		this.amount = amount;
		this.type = type;
		this.isServed = false;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String toString(){
		
		if(isServed == false){
			return getAmount() + "l  " + super.getName() + " ---- " + super.getPrice()+"Kr.";
		}else{
			return servedString();
		}
	}
	public String moreInfo(){
		return super.getName() + "\n" + super.getDescription() + "\n" + "Amount: " +
				getAmount() + "l\n" + "Price: " + super.getPrice() + "Kr.";
	}

	@Override
	public String getType() {
		return type;
	}

	public void setAsServed(){
		isServed = true;
	}
	
	public boolean isServed(){
		return isServed;
	}

	@Override
	public void setAsPrepared() {
		// TODO Auto-generated method stub
		
	}
	
	public String servedString(){
		return getAmount() + "l  " + super.getName() + "-- " + super.getDescription() + "---- " + super.getPrice()+"Kr. -- IS SERVED";
	}

	@Override
	public boolean isPrepared() {
		// TODO Auto-generated method stub
		return false;
	}

}
