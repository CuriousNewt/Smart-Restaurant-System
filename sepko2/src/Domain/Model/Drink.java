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
		return super.getName() + "\n" + super.getDescription() + "\n" + getAmount() + "l " + super.getPrice()+"Kr."
				+ "\n" + "----------------------------------" + "\n";
	}

	@Override
	public String getType() {
		return type;
	}

}
