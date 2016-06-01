package Domain.Mediator;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.Model.Drink;
import Domain.Model.Item;
import Domain.Model.Meal;
import Domain.Model.Order;

public class Database implements Storage {

	private String ip;
	private ModelManager manager;
	private int orderID;

		/**
	    * Constructor setting up ModelManager, IP variable and orderID.
	    * @param filepath Path to the file with the IP of the database.
	    * @param manager, which is setting the local variable manager.
	    */
	public Database(String filepath, ModelManager manager) {
		this.manager = manager;
		this.orderID = 1;
		try {
			this.ip = "jdbc:postgresql://" + ReadIP.getReadIP(filepath).getIP();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
		/**
	    * Method getting menu from the database through the connection and calling methods for filling up menu.
	    * @throws SQLException If there is a problem between program and database.
	    */
	public void getMenu() throws SQLException {

		DriverManager.registerDriver(new org.postgresql.Driver());
		Connection connection = DriverManager.getConnection(ip, "postgres",
				"Admin");
		try {
			PreparedStatement statementMeal = connection
					.prepareStatement("SELECT * FROM meal");
			ResultSet resultMeal = statementMeal.executeQuery();
			this.getMealToMenu(resultMeal);

			PreparedStatement statementDrink = connection
					.prepareStatement("SELECT * FROM drink");
			ResultSet resultDrink = statementDrink.executeQuery();
			this.getDrinkToMenu(resultDrink);

		} finally {
			connection.close();
		}
	}

		/**
	    * Method adding item to the database through the connection.
	    * @param item Item, which is added to the database.
	    * @throws SQLException If there is a problem between program and database.
	    */
	public void addToMenu(Item item) throws SQLException {

		org.postgresql.Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(ip, "postgres",
				"Admin");
		try {
			if (item instanceof Meal) {
				Meal meal = (Meal) item;
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO meal VALUES('"
								+ meal.getName() + "', '"
								+ meal.getDescription() + "', "
								+ meal.getPrice() + ", " + meal.getAmount()
								+ ", '" + meal.getType() + "')");
				statement.executeUpdate();
			} else if (item instanceof Drink) {
				Drink drink = (Drink) item;
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO drink VALUES('"
								+ drink.getName() + "', '"
								+ drink.getDescription() + "', "
								+ drink.getPrice() + ", " + drink.getAmount()
								+ ", '" + drink.getType() + "')");
				statement.executeUpdate();
			}
		} finally {
			connection.close();
		}
	}

		/**
	    * Method removing item from the database through the connection.
	    * @param item Item, which is removed from the menu.
	    * @throws SQLException If there is a problem between program and database.
	    */
	@Override
	public void removeFromMenu(Item item) throws SQLException {
		org.postgresql.Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(ip, "postgres",
				"Admin");
		try {
			if (item instanceof Meal) {
				Meal meal = (Meal) item;
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM meal WHERE name = '"
								+ item.getName() + "'");
				statement.executeUpdate();
			} else if (item instanceof Drink) {
				Drink drink = (Drink) item;
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM drink WHERE name = '"
								+ item.getName() + "'");
				statement.executeUpdate();
			}
		} finally {
			connection.close();
		}

	}

		/**
	    * Method adding paid order to the past orders in the database through the connection.
	    * @param order Order, which is moved to the past orders in the database.
	    * @throws SQLException If there is a problem between program and database.
	    */	
	@Override
	public void addToPastOrders(Order order) throws SQLException {
		org.postgresql.Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(ip, "postgres",
				"Admin");
		try {
			for (int i = 0; i < order.size(); i++) {
				PreparedStatement statementPastOrders = connection
						.prepareStatement("INSERT INTO past_orders (order_number, date, name, price, amount) VALUES "
								+ "(" + orderID + "," + "CURRENT_DATE" + ", '"
								+ order.getItem(i).getName() + "', "
								+ order.getItem(i).getPrice() + ", "
								+ (Double) order.getItem(i).getAmount()+ ");");
				statementPastOrders.executeUpdate();
			}
			orderID++;
		} finally {
			connection.close();
		}

	}
	
		/**
	    * Method getting past orders from the database through the connection and calling methods for filling up PastOrdersGUI. 
	    * @param date Date, when the order was paid.
	    * @throws SQLException If there is a problem between program and database.
	    */
	@Override
	public void getAllPastOrders(Date date) throws SQLException {
		ResultSet temp;
		
		org.postgresql.Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(ip, "postgres",
				"Admin");
		
		try {
				PreparedStatement statementPastOrders = connection
						.prepareStatement("SELECT * FROM past_orders");
				temp = statementPastOrders.executeQuery();
				getPastOrdersToList(temp, date);
				
		} finally {
			connection.close();
		}
		

	}

	
		/**
	    * Method calling manager for filling up meal to the menu on the client side. 
	    * @param result Result variable filled up with data from database.
	    * @throws SQLException If there is a problem between program and database.
	    */
	private void getMealToMenu(ResultSet result) throws SQLException {
		while (result.next()) {
			manager.getMenu().addMeal(result.getString("name"),
					result.getString("description"), result.getDouble("price"),
					result.getInt("amount"), result.getString("type"));
		}
	}
	
		/**
	    * Method calling manager for filling up list of past orders for date on the server side. 
	    * @param result Result variable filled up with data from database.
	    * @param date Date variable for returning the past orders of the right date.
	    * @throws SQLException If there is a problem between program and database.
	    */
	private void getPastOrdersToList(ResultSet result, Date date) throws SQLException {
		while (result.next()) {
				
			if(result.getDate("date").equals(date)){
				String temp = "Order ID: " +result.getInt("order_number") + " | Date: " + result.getDate("date") + " | Name: " + result.getString("name") 
						+ " | Price: " + result.getDouble("price") + "kr. | Amount: " + result.getDouble("amount");
					manager.getPastOrders().add(temp);
			}
		}
	}

		/**
	    * Method calling manager for filling up drinks to the menu on the client side. 
	    * @param result Result variable filled up with data from database.
	    * @throws SQLException If there is a problem between program and database.
	    */
	private void getDrinkToMenu(ResultSet result) throws SQLException {
		while (result.next()) {
			manager.getMenu().addDrink(result.getString("name"),
					result.getString("description"), result.getDouble("price"),
					result.getDouble("amount"), result.getString("type"));
		}
	}

}
