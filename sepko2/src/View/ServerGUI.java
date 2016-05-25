package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

import Controller.Controller;
import Domain.Model.Item;
import Domain.Model.Table;

public class ServerGUI extends JFrame {

	private EditMenuGUI editMenuGui;
	private JMenuBar topMenuBar;
	private JMenu topMenu;
	private JMenuItem menuItemEditMenu;
	private Controller controller;

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
	private JButton payedButton;
	private JButton setAsBringed;
	private JButton selectButton;

	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<String> listOfTables;
	private JList<String> listOfOrders;
	private DefaultListModel tablesModel;
	private DefaultListModel ordersModel;

	public ServerGUI(Controller controller) throws Exception {
		this.controller = controller;
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
		editMenuGui = new EditMenuGUI();

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
		payedButton = new JButton("Set selected order as paid");
		setAsBringed = new JButton("Set selected order as served");
		selectButton = new JButton("Show orders of the selected table");

		// JLISTS & DEFAULT LIST MODELS
		// *************************************************
		tablesModel = new DefaultListModel();
		ordersModel = new DefaultListModel();
		listOfTables = new JList<String>(tablesModel);
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
		eastButtonPanel.add(payedButton);
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
	}

	public void updateListOfOrders(int tableNumber) {
		ordersModel.clear();
		for (int i = 0; i < controller.showOrders(tableNumber).size(); i++) {
			ordersModel.add(i, controller.showOrders(tableNumber).get(i));
			// TODO displaying items and tables
		}

	}

	class RemoveItem implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JList list = listOfOrders;
			Item item = (Item) list.getSelectedValue();
			controller.removeItemFromOrder(item,
					listOfTables.getSelectedIndex());
			updateListOfOrders(listOfTables.getSelectedIndex() + 1);

		}
	}

	public class ViewTableOrder implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				JList temp = (JList) e.getSource();
				Table table = (Table) temp.getSelectedValue();
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

	/*
	 * public static void main(String[] args) throws Exception { ServerGUI gui =
	 * new ServerGUI(); gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
	 * gui.setVisible(true); }
	 */
	public void addTableToList(Object table) {
		tablesModel.addElement(table);
	}

}
