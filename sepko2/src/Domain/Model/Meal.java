package Domain.Model;

public class Meal extends Item {
	private int amount;
	private String type;
	private boolean isPrepared;
	
	public Meal(String name, String description, double price, int amount, String type) {
		super(name, description, price);
		this.amount = amount;
		this.type = type.toLowerCase();
		this.isPrepared = false;
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
		return  (int)getAmount() + "g  " + super.getName() + "---" + super.getPrice()+"Kr.";
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

	@Override
	public void setAsServed() {
		// TODO Auto-generated method stub
		
	}

}
