package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.Controller;
import Domain.Mediator.Database;
import Domain.Model.Item;
import Domain.Model.Meal;
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

	// JSROLLPANES
	// *********************************************************************
	private JScrollPane TablesScrollPane;
	private JScrollPane OrdersScrollPane;

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
	private JList<Item> listOfOrders;
	private DefaultListModel<Table> tablesModel;
	private DefaultListModel<Item> ordersModel;

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
		ordersEditButton = new JButton("Remove item");
		paidButton = new JButton("Set order as paid");
		setAsBringed = new JButton("Set item as served");
		selectButton = new JButton("Show orders of the table");

		// JLISTS & DEFAULT LIST MODELS
		// *************************************************
		tablesModel = new DefaultListModel();
		ordersModel = new DefaultListModel();
		listOfTables = new JList<Table>(tablesModel);
		listOfTables.setFont(new Font("Arial", Font.BOLD, 19));
		listOfOrders = new JList<Item>(ordersModel);
		listOfOrders.setFont(new Font("Arial", Font.BOLD, 19));

		// JSROLLPANES
		// *********************************************************************
		TablesScrollPane = new JScrollPane(listOfTables);
		OrdersScrollPane = new JScrollPane(listOfOrders);

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

		eastListPanel.add(OrdersScrollPane);

		eastButtonPanel.add(ordersEditButton);
		eastButtonPanel.add(paidButton);
		eastButtonPanel.add(setAsBringed);

		westButtonPanel.add(selectButton);
		westListPanel.add(TablesScrollPane);

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
			ordersModel.add(i, controller.showOrders(tableNumber).get(i));
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
			try {
				if (listOfTables.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(ServerGUI.this,
							"First, select a table served");
				} else {
					int index = listOfOrders.getSelectedIndex();
					listOfOrders.getSelectedValue().setAsServed();
					Item temp = listOfOrders.getSelectedValue();
					ordersModel.remove(index);
					ordersModel.insertElementAt(temp, index);
				}
			} catch (NullPointerException exception) {
				JOptionPane.showMessageDialog(ServerGUI.this,
						"First, select a table served");
			}

		}
	}

	class AddPastOrder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JList temp = (JList) listOfTables;
			try {
				Table table = (Table) temp.getSelectedValue();
				if (table.getOrder().size() == 0)
					JOptionPane.showMessageDialog(ServerGUI.this,
							"No orders to pay");
				else {
					database.addToPastOrders(table.getOrder());
					JOptionPane.showMessageDialog(ServerGUI.this,
							"Total price to pay: "
									+ table.getOrder().getPrice());
					ordersModel.clear();
					table.remvoeWhenPaid();
				}
			} catch (NullPointerException | SQLException exception) {
				JOptionPane.showMessageDialog(ServerGUI.this,
						"First, select a table of which order is being paid");
			}

		}
	}

	class RemoveItem implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int dialogButton = JOptionPane.showConfirmDialog(ServerGUI.this,
					"Do you really want to delete this item?", "Confrim",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (dialogButton == JOptionPane.YES_OPTION) {
				JList list = listOfOrders;
				try {
					Item item = (Item) list.getSelectedValue();
					if (ordersModel.isEmpty())
						JOptionPane.showMessageDialog(ServerGUI.this,
								"No items to remove");
					else {
						if (list.getSelectedIndex() == -1) {
							JOptionPane
									.showMessageDialog(ServerGUI.this,
											"First, select the item you want to remove");
						} else {
							controller.removeItemFromOrder(item,
									listOfTables.getSelectedIndex());
							updateListOfOrders(listOfTables.getSelectedIndex());
							if (item instanceof Meal) {
								rmiService.updateKitchenRemoveItem(item);
							}
						}
					}
				} catch (NullPointerException | ArrayIndexOutOfBoundsException
						| RemoteException exception) {
					JOptionPane.showMessageDialog(ServerGUI.this,
							"Select an item you want to remove first");
				}
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
							"No orders to serve");
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
							"No orders to serve for the table number "
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
		JOptionPane.showMessageDialog(ServerGUI.this, "Customer at the table number " + ID
				+ " requests your assistance.");

	}

	public void addTableToList(Table table) {
		tablesModel.addElement(table);
	}

	public void colourBackground(int ID) {
		listOfTables.setSelectedIndex(ID - 1);

		JOptionPane.showMessageDialog(ServerGUI.this, "New order to the table number " + ID);
	}

}
