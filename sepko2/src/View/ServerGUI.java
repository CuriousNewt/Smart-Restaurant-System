package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class ServerGUI extends JFrame {

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
	private JLabel JLabelWest;
	
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

	public ServerGUI() throws Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SEP Restaurant System");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
		pack();
	}

	private void setComponents() {
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
		ordersEditButton = new JButton("Edit...");
		payedButton = new JButton("Set as payed");
		setAsBringed = new JButton("Set as bringed");
		selectButton = new JButton("Select table");

		// JLISTS & DEFAULT LIST MODELS
		// *************************************************
		tablesModel = new DefaultListModel();
		ordersModel = new DefaultListModel();
		listOfTables = new JList<String>(tablesModel);
		listOfOrders = new JList<String>(ordersModel);

		// JLABELS
		// **********************************************************************
		JLabelWest = new JLabel("Karate kid");
	}

	private void addBorders(){
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

	}

	public static void main(String[] args) throws Exception {
		ServerGUI gui = new ServerGUI();
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}
}
