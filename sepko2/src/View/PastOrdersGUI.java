package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Domain.Mediator.Database;
import Domain.Mediator.ModelManager;
import Domain.Model.Item;

import com.toedter.calendar.JDateChooser;

public class PastOrdersGUI extends JFrame {

	private Database database;
	private ModelManager manager;
	
	// JPANELS
	// *********************************************************************
	private JPanel mainPanel;
	private JPanel centerPanel;
	private JPanel northPanel;


	// JLABELS
	// *********************************************************************
	private JLabel totalDayPriceLabel;
	private JLabel amountOfItemsSoldLabel;



	// JBUTTONS
	// *********************************************************************
	private JButton searchButton;
	

	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<Item> orderList;

	private JDateChooser calendar;

	private DefaultListModel<String> orderListModel;


	public PastOrdersGUI(Database database, ModelManager manager) throws Exception {
		this.database = database;
		this.manager = manager;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SEP Restaurant System - Past orders menu");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
		addActionListeners();
		pack();
	}

	private void setComponents() {

		calendar = new JDateChooser();

		// JPANELS
		// **********************************************************************
		mainPanel = new JPanel();
		centerPanel = new JPanel();
		northPanel = new JPanel();

		// JBUTTONS
		// *********************************************************************
		searchButton = new JButton("Search");
		
		// JLISTS & DEFAULT LIST MODELS
		orderListModel = new DefaultListModel<String>();
		
		orderList = new JList(orderListModel);

		
		// JLABELS
		// **********************************************************************
		totalDayPriceLabel = new JLabel("Total Price: ");
		amountOfItemsSoldLabel = new JLabel("Total items sold: ");
	
	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

	}

	private void addActionListeners(){
		searchButton.addActionListener(new UpdateList());
	}
	
	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS
		// ***********************************************************
		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout());
		northPanel.setLayout(new GridLayout(3,1));

		

		// ADDING INTO PANELS
		// *********************************************************************
				

		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(searchButton,BorderLayout.SOUTH);

		northPanel.add(calendar);
		northPanel.add(totalDayPriceLabel);
		northPanel.add(amountOfItemsSoldLabel);
		
		centerPanel.add(orderList);
		
	
		add(mainPanel, BorderLayout.CENTER);

	}

	class UpdateList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			orderListModel.clear();
			try {
				database.getAllPastOrders((Date) calendar.getDate());
				
			} catch (SQLException | NullPointerException e) {
				if(e instanceof NullPointerException)
					JOptionPane.showMessageDialog(PastOrdersGUI.this, "First, select the date you want to check");
				else if (e instanceof SQLException) {
					if(orderListModel.isEmpty()) {
						JOptionPane.showMessageDialog(PastOrdersGUI.this, "No past orders for selected date");
					} else {
						JOptionPane.showMessageDialog(PastOrdersGUI.this, "Database issues! Call your IT service");
					}
				}
			}
		    
			for(int i=0;i<manager.getPastOrders().size();i++){
				orderListModel.addElement(manager.getPastOrders().get(i)); 
			}	
		}	
	}
}
