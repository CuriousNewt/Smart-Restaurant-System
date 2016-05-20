package Domain.Model;

public class Drink extends Item {
	private double amount;
	private String type;
	
	public Drink(String name, String description, double price, double amount, String type) {
		super(name, description, price);
		this.amount = amount;
		this.type = type;
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
		return getAmount() + "l  " + super.getName() + "-- " + super.getDescription() + "---- " + super.getPrice()+"Kr.";
	}

	@Override
	public String getType() {
		return type;
	}

}
