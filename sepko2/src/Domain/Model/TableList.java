package Domain.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class TableList implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Table> tables;
	
	public TableList(){
		this.tables = new ArrayList<Table>();
	}
	
	public void addTable(Table table){
		tables.add(table);
	}
	
	public Table getTable(int index){
		return tables.get(index);
	}
	
	
	
	
}
