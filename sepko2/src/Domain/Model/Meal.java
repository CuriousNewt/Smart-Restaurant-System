package Domain.Model;

public class Meal extends Item {
	private int amount;
	private String type;
	
	public Meal(String name, String description, double price, int amount, String type) {
		super(name, description, price);
		this.amount = amount;
		this.type = type.toLowerCase();
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
		return  (int)getAmount() + "g  " + super.getName() + "-- " + super.getDescription() + "---- " + super.getPrice()+"Kr.";
	}

	@Override
	public String getType() {
		return type;
	}

}
