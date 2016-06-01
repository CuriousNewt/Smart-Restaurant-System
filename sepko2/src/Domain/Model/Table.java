package Domain.Model;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.Serializable;



public class Table implements Serializable {
	private Order order;
	private int tableNumber;

	
		/**
	    * Constructor setting up table number and creating new order.
	    * @param tableNumber to set. 
	    */
	public Table(int tableNumber) {
		this.tableNumber = tableNumber;
		this.order = new Order();
	}

		/**
	    * toString method for Table.
	    * @return String
	    */
	public String toString() {
		return "Table number " + tableNumber;
	}

		/**
	    * Method for adding Item to an order ArrayList.
	    * @param item to add.
	    */
	public void addItemToOrder(Item item) {
		this.order.addItem(item);
	}

		/**
	    * Method for removing Item from an order ArrayList.
		* @param item to remove.
	    */
	public void removeItem(Item item) {
		this.order.removeItem(item);
	}

		/**
	    * Method returning an order object.
	    * @return Order
	    */
	public Order getOrder() {
		return order;
	}

		/**
	    * Method returning tableNumber variable.
	    * @return int
	    */
	public int getTableNumber() {
		return tableNumber;
	}
	
		/**
	    * Method creating new Order ArrayList.
	    */
	public void remvoeWhenPaid(){
		this.order = new Order();
	}
}
