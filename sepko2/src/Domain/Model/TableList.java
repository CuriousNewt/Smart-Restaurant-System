package Domain.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class TableList implements Serializable {
	private ArrayList<Table> tables;

	public TableList() {
		this.tables = new ArrayList<Table>();
	}

	public void addTable(Table table) {
		tables.add(table);
	}

	public Table getTable(int index) {
		return tables.get(index);
	}

}
