package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;






import javax.swing.ListCellRenderer;

import Controller.Controller;
import Domain.Mediator.Database;
import Domain.Model.Item;
import Domain.Model.Table;
import Utility.RmiServerInterface;

public class ServerGUI extends JFrame {

	private EditMenuGUI editMenuGui;
	private PastOrdersGUI pastOrdersGui;
	private JMenuBar topMenuBar;
	private JMenu topMenu;
	private JMenuItem menuItemEditMenu;
	private JMenuItem menuItempastOrders;
	private Controller controller;
	private Database database;
	private RmiServerInterface rmiService;

	// JPANELS
	// *********************************************************************
	private JPanel mainPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel eastButtonPanel;
	private JPanel eastListPanel;
	private JPanel westButtonPanel;
	private JPanel westListPanel;

	// JLABELS
	// *********************************************************************

	// JBUTTONS
	// *********************************************************************
	private JButton ordersEditButton;
	private JButton paidButton;
	private JButton setAsBringed;
	private JButton selectButton;

	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<Table> listOfTables;
	private JList<String> listOfOrders;
	private DefaultListModel tablesModel;
	private DefaultListModel<String> ordersModel;

	public ServerGUI(Controller controller, Database database,
			RmiServerInterface rmiService) throws Exception {
		this.database = database;
		this.controller = controller;
		this.rmiService = rmiService;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(topMenuBar);
		setTitle("SEP Restaurant System");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
		addActionListeners();
		pack();

	}

	private void setComponents() throws Exception {

		// TOP MENU BAR
		// **********************************************************************
		topMenuBar = new JMenuBar();
		topMenu = new JMenu("Edit");
		menuItemEditMenu = new JMenuItem("Edit menu..");
		menuItempastOrders = new JMenuItem("Past orders..");
		editMenuGui = new EditMenuGUI(database, controller, rmiService);
		pastOrdersGui = new PastOrdersGUI(database, controller.getManager());

		// JPANELS
		// **********************************************************************
		westPanel = new JPanel();
		eastPanel = new JPanel();
		eastButtonPanel = new JPanel();
		mainPanel = new JPanel();
		eastListPanel = new JPanel();
		westButtonPanel = new JPanel();
		westListPanel = new JPanel();

		// JBUTTONS
		// *********************************************************************
		ordersEditButton = new JButton("Remove selected item");
		paidButton = new JButton("Set selected order as paid");
		setAsBringed = new JButton("Set selected order as served");
		selectButton = new JButton("Show orders of the selected table");

		// JLISTS & DEFAULT LIST MODELS
		// *************************************************
		tablesModel = new DefaultListModel();
		ordersModel = new DefaultListModel();
		listOfTables = new JList<Table>(tablesModel);
		listOfOrders = new JList<String>(ordersModel);

		// JLABELS
		// **********************************************************************
	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		eastPanel.setBorder(BorderFactory.createTitledBorder("ORDERS"));
		westPanel.setBorder(BorderFactory.createTitledBorder("TABLES"));

	}

	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS
		// ***********************************************************
		mainPanel.setLayout(new GridLayout(1, 1));
		eastPanel.setLayout(new BorderLayout());
		westPanel.setLayout(new BorderLayout());

		eastButtonPanel.setLayout(new GridLayout(1, 6));
		eastListPanel.setLayout(new BorderLayout());
		westButtonPanel.setLayout(new GridLayout(1, 1));
		westListPanel.setLayout(new BorderLayout());

		// ADDING INTO PANELS
		// *********************************************************************
		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);

		eastListPanel.add(listOfOrders);

		eastButtonPanel.add(ordersEditButton);
		eastButtonPanel.add(paidButton);
		eastButtonPanel.add(setAsBringed);

		westButtonPanel.add(selectButton);
		westListPanel.add(listOfTables);

		eastPanel.add(eastButtonPanel, BorderLayout.SOUTH);
		eastPanel.add(eastListPanel, BorderLayout.CENTER);

		westPanel.add(westButtonPanel, BorderLayout.SOUTH);
		westPanel.add(westListPanel, BorderLayout.CENTER);

		add(mainPanel, BorderLayout.CENTER);
		add(topMenuBar, BorderLayout.NORTH);
		topMenuBar.add(topMenu);
		topMenu.add(menuItemEditMenu);
		topMenu.add(menuItempastOrders);
	}

	// ADDING FUNCTIONS
	// *********************************************************************
	class OpenEditMenu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			editMenuGui.setVisible(true);
			editMenuGui.setExtendedState(JFrame.MAXIMIZED_BOTH);
			editMenuGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	

	public void addActionListeners() {
		menuItemEditMenu.addActionListener(new OpenEditMenu());
		listOfTables.addMouseListener(new ViewTableOrder());
		ordersEditButton.addActionListener(new RemoveItem());
		selectButton.addActionListener(new ViewButton());
		paidButton.addActionListener(new AddPastOrder());
		menuItempastOrders.addActionListener(new OpenPastOrdersGUI());
		setAsBringed.addActionListener(new servedButton());
	}

	public void updateListOfOrders(int tableNumber) {
		ordersModel.clear();
		for (int i = 0; i < controller.showOrders(tableNumber).size(); i++) {
			ordersModel.add(i, controller.showOrders(tableNumber).get(i).toString());
			// TODO displaying items and tables
		}

	}
	class OpenPastOrdersGUI implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			pastOrdersGui.setVisible(true);
			pastOrdersGui.setExtendedState(JFrame.MAXIMIZED_BOTH);
			pastOrdersGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		}
		
	}

	class servedButton implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = listOfOrders.getSelectedIndex();
			String temp = listOfOrders.getSelectedValue().toString() + " - SERVED";
			ordersModel.setElementAt(temp, index);
			
			
			
		}
	}
	
	class AddPastOrder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JList temp = (JList) listOfTables;
			Table table = (Table) temp.getSelectedValue();
			try {
				database.addToPastOrders(table.getOrder());
				ordersModel.clear();
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}

		}
	}

	class RemoveItem implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JList list = listOfOrders;
			try {
				Item item = (Item) list.getSelectedValue();
				controller.removeItemFromOrder(item,
						listOfTables.getSelectedIndex());
				updateListOfOrders(listOfTables.getSelectedIndex());
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(ServerGUI.this,
						"Select an item you want to remove first");
			}
		}
	}

	class ViewButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JList temp = listOfTables;
			try {
				Table table = (Table) temp.getSelectedValue();
				if (table.getOrder().size() == 0) {
					JOptionPane.showMessageDialog(
							ServerGUI.this,
							"NO ORDERS TO SERVE FOR TABLE "
									+ table.getTableNumber());
				}
				updateListOfOrders(table.getTableNumber() - 1);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(ServerGUI.this,
						"Select the table you want to check first");
			}
		}
	}

	public class ViewTableOrder implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				JList temp = (JList) e.getSource();
				Table table = (Table) temp.getSelectedValue();
				if (table.getOrder().size() == 0) {
					JOptionPane.showMessageDialog(
							ServerGUI.this,
							"NO ORDERS TO SERVE FOR TABLE "
									+ table.getTableNumber());
				}
				updateListOfOrders(table.getTableNumber() - 1);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public void callStaff(int ID) {
		JOptionPane.showMessageDialog(ServerGUI.this, "Table number " + ID
				+ " requests your assistance.");

	}

	public void addTableToList(Object table) {
		tablesModel.addElement(table);
	}

	public void colourBackground(int ID) {
		JOptionPane.showMessageDialog(ServerGUI.this, "Table number " + ID
				+ " made an order.");
		
	}

	
}
	
	

