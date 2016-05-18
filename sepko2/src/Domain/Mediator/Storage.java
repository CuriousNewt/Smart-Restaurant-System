package Domain.Mediator;

import java.sql.SQLException;

import Domain.Model.Item;

public interface Storage {
	void getMenu() throws SQLException;
	void addToMenu(Item item) throws SQLException;
	void removeFromMenu(Item item) throws SQLException;
	void addToPastOrders(Item item) throws SQLException;
	void getAllPastOrders() throws SQLException;
}