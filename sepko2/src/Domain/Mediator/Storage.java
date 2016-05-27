package Domain.Mediator;

import java.util.Date;
import java.sql.SQLException;

import Domain.Model.Item;
import Domain.Model.Order;

public interface Storage {
	void getMenu() throws SQLException;

	void addToMenu(Item item) throws SQLException;

	void removeFromMenu(Item item) throws SQLException;

	void addToPastOrders(Order order) throws SQLException;

	void getAllPastOrders(Date date) throws SQLException;
}