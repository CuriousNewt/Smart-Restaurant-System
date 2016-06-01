package Domain.Model;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
*/
import java.io.Serializable;
import java.util.ArrayList;

public class TableList implements Serializable {
	private ArrayList<Table> tables;

	
		/**
	    * Constructor creating new ArrayList of Tables.
	    */
	public TableList() {
		this.tables = new ArrayList<Table>();
	}

		/**
	    * Method for adding a table to the ArrayList. 
	    * @param table to add
	    */
	public void addTable(Table table) {
		tables.add(table);
	}

		/**
	    * Method for getting the table by index from the ArrayList. 
	    * @param index of item to add
	    * @return Table
	    */
	public Table getTable(int index) {
		return tables.get(index);
	}

		/**
	    * Method for returning size of ArrayList. 
	    * @return int
	    */
	public int size() {
		return tables.size();
	}

}
