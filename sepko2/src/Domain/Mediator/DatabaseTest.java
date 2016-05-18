package Domain.Mediator;

import java.sql.SQLException;

import Domain.Model.Meal;

public class DatabaseTest {
	public static void main(String[] args) {
		ModelManager manager = new ModelManager();
		Database db = new Database("databaseIP", manager);
		Meal meal = new Meal("krumple", "krumple s mliekom ty kokotecek", 100, 500,"appetizers");
		try {
			db.addToMenu(meal);
			db.getMenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(manager.getMenu().show());
	}
}