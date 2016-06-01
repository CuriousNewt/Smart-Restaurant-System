package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.util.Date;
import java.sql.SQLException;

import Domain.Model.Item;
import Domain.Model.Order;

public interface Storage {
	
		/**
	    * Database interfacce method getting menu from the database through the connection and calling methods for filling up menu.
	    * @throws SQLException If there is a problem between program and database.
	    */
	void getMenu() throws SQLException;

		/**
	    * Database interfacce method adding item to the database through the connection.
	    * @param item Item, which is added to the database.
	    * @throws SQLException If there is a problem between program and database.
	    */
	void addToMenu(Item item) throws SQLException;

		/**
	    * Database interfacce method removing item from the database through the connection.
	    * @param item Item, which is removed from the menu.
	    * @throws SQLException If there is a problem between program and database.
	    */
	void removeFromMenu(Item item) throws SQLException;

		/**
	    * Database interfacce method adding paid order to the past orders in the database through the connection.
	    * @param order Order, which is moved to the past orders in the database.
	    * @throws SQLException If there is a problem between program and database.
	    */	
	void addToPastOrders(Order order) throws SQLException;

		/**
	    * Database interfacce method getting past orders from the database through the connection and calling methods for filling up PastOrdersGUI. 
	    * @param date Date, when the order was paid.
	    * @throws SQLException If there is a problem between program and database.
	    */
	void getAllPastOrders(Date date) throws SQLException;
}