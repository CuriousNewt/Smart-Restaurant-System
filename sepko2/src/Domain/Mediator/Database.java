package Domain.Mediator;

import java.io.FileNotFoundException;
import java.sql.Connection;
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
	
	public Database(String filepath, ModelManager manager) {
		this.manager = manager;
		try {
			this.ip = "jdbc:postgresql://" + ReadIP.getReadIP(filepath).getIP();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void getMenu() throws SQLException  {
		
		DriverManager.registerDriver(new org.postgresql.Driver());
		Connection connection = DriverManager.getConnection(ip, "postgres", "root");
		try {
			PreparedStatement statementMeal = connection.prepareStatement("SELECT * FROM meal");
			ResultSet resultMeal = statementMeal.executeQuery();
			this.getMealToMenu(resultMeal);
			
			PreparedStatement statementDrink = connection.prepareStatement("SELECT * FROM drink");
			ResultSet resultDrink = statementDrink.executeQuery();
			this.getDrinkToMenu(resultDrink);
			
		} finally {
			connection.close();
		}
	}
	
	public void addToMenu(Item item) throws SQLException {
		
		org.postgresql.Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection
				(ip, "postgres", "root");
		try {
			if(item instanceof Meal){
			Meal meal = (Meal) item;
			PreparedStatement statement = connection.prepareStatement
					("INSERT INTO meal VALUES('" + meal.getName() + "', '" + meal.getDescription() + "', "
							+ meal.getPrice() + ", " + meal.getAmount() + ", '" + meal.getType() + "')");
			statement.executeUpdate();
			}
			else if(item instanceof Drink) {
				Drink drink = (Drink) item;
				PreparedStatement statement = connection.prepareStatement
						("INSERT INTO drink VALUES('" + drink.getName() + "', '" + drink.getDescription() + "', "
								+ drink.getPrice() + ", " + drink.getAmount() + ", '" + drink.getType() + "')");
				statement.executeUpdate();
			}
		} finally {
			connection.close();
		}
	}


	@Override
	public void removeFromMenu(Item item) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addToPastOrders(Order order) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void getAllPastOrders() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	private void getMealToMenu(ResultSet result) throws SQLException {
		while(result.next()) {
			manager.getMenu().addMeal(result.getString("name"), result.getString("description"),
					result.getDouble("price"), result.getInt("amount"), result.getString("type"));
		}
	}
	private void getDrinkToMenu(ResultSet result) throws SQLException {
		while(result.next()) {
			manager.getMenu().addDrink(result.getString("name"), result.getString("description"),
					result.getDouble("price"), result.getDouble("amount"), result.getString("type"));
		}
	}

}