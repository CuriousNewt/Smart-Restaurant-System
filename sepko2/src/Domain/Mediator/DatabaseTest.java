package Domain.Mediator;

import java.sql.SQLException;

public class DatabaseTest {
	public static void main(String[] args) {
		Database db = new Database("databaseIP");
		try {
			db.getFromMenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
