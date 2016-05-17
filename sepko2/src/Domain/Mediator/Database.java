package Domain.Mediator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database {
	
	private String ip;
	
	public Database(String filepath) {
		try {
			this.ip = "jdbc:postgresql://" + ReadIP.getReadIP(filepath).getIP()
					+ ":5432/postgres";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void getFromMenu(int index) throws SQLException {
		// TODO change ip and statements only example
		DriverManager.registerDriver(new org.postgresql.Driver());
		Connection connection = DriverManager.getConnection
				(ip, "postgres", "admin");
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM niečo");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("niečo"));
				System.out.println(result.getInt("niečo"));
				System.out.println(result.getString("niečo"));
				System.out.println();
			}
		} finally {
			connection.close();
		}
	}
	
	public void updateDataToDb() throws SQLException {
		// TODO change ip and statements only example, add some paramater 
		int account_type = 2;
		String account_number = "4984 2142 2349";
		org.postgresql.Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection
				(ip, "postgres", "password");
		try {
			PreparedStatement statement = connection.prepareStatement
					("UPDATE \"Bank\".accounts SET account_type = ? WHERE account_number = ?");
			statement.setInt(1, account_type);
			statement.setString(2, account_number);
			statement.executeUpdate();
		} finally {
			connection.close();
		}
	}
}
