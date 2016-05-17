package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ClientGUI extends JFrame {
	
	private JMenuBar topMenuBar;
	private JMenu topMenu;
	private JMenuItem menuItemEditMenu;
	private JTabbedPane menuTabs;

	// JPANELS
	// *********************************************************************
	private JPanel mainPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel eastButtonPanel;
	private JPanel eastListPanel;
	private JPanel westButtonPanel;
	private JPanel westListPanel;
	private JPanel centerButtonPanel;
	
	private JPanel porkPanel;
	private JPanel beefPanel;
	private JPanel chickenPanel;
	private JPanel soupPanel;
	private JPanel seaFood;
	private JPanel sideDish;
	private JPanel desert;
	private JPanel appetizer;
	private JPanel nonAlcoholicDrinks;
	private JPanel alcoholicDrinks;
	
	

	// JLABELS
	// *********************************************************************

	// JBUTTONS
	// *********************************************************************
	private JButton plusButton;
	private JButton orderButton;
	private JButton minusButton;
	private JButton callStaffButton;
	

	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<String> porkList;
	private JList<String> beefList;
	private JList<String> chickenList;
	private JList<String> soupList;
	private JList<String> seaFoodList;
	private JList<String> sideDishList;
	private JList<String> desertList;
	private JList<String> appetizerList;
	private JList<String> nonAlcoholicDrinksList;
	private JList<String> alcoholicDrinksList;
	private JList<String> listOfOrder;
	
	
	private DefaultListModel<String> porkModel;
	private DefaultListModel<String> beefModel;
	private DefaultListModel<String> chickenModel;
	private DefaultListModel<String> soupModel;
	private DefaultListModel<String> seaFoodModel;
	private DefaultListModel<String> sideDishModel;
	private DefaultListModel<String> desertModel;
	private DefaultListModel<String> appetizerModel;
	private DefaultListModel<String> nonAlcoholicDrinksModel;
	private DefaultListModel<String> alcoholicDrinksModel;
	private DefaultListModel<String> modelOfOrders;

	public ClientGUI() throws Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(topMenuBar);
		setTitle("SEP Restaurant System");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
		plusButton.setPreferredSize(new Dimension(50, 50));
		minusButton.setPreferredSize(new Dimension(50, 50));
		pack();
	}

	private void setComponents() {

		// TOP MENU BAR
		// **********************************************************************
		topMenuBar = new JMenuBar();
		topMenu = new JMenu("Edit");
		menuItemEditMenu = new JMenuItem("Edit menu..");
		menuTabs = new JTabbedPane();

		// JPANELS
		// **********************************************************************
		westPanel = new JPanel();
		eastPanel = new JPanel();
		eastButtonPanel = new JPanel();
		mainPanel = new JPanel();
		eastListPanel = new JPanel();
		westButtonPanel = new JPanel();
		westListPanel = new JPanel();
		centerButtonPanel = new JPanel();
		
		porkPanel = new JPanel();
		beefPanel = new JPanel();
		chickenPanel = new JPanel();
		soupPanel = new JPanel();
		seaFood = new JPanel();
		sideDish = new JPanel();
		desert = new JPanel();
		appetizer = new JPanel();
		nonAlcoholicDrinks = new JPanel();
		alcoholicDrinks = new JPanel();

		// JBUTTONS
		// *********************************************************************
		minusButton = new JButton("-");
		plusButton = new JButton("+");
		orderButton = new JButton("Order");
		callStaffButton = new JButton("Call saff");

		// JLISTS & DEFAULT LIST MODELS
		porkModel = new DefaultListModel<String>();
		beefModel = new DefaultListModel<String>();
		chickenModel = new DefaultListModel<String>();
		soupModel = new DefaultListModel<String>();
		seaFoodModel = new DefaultListModel<String>();
		sideDishModel = new DefaultListModel<String>();
		desertModel = new DefaultListModel<String>();
		appetizerModel = new DefaultListModel<String>();
		nonAlcoholicDrinksModel = new DefaultListModel<String>();
		alcoholicDrinksModel = new DefaultListModel<String>();
		modelOfOrders = new DefaultListModel<String>();
		
		porkList = new JList(porkModel);
		beefList = new JList(beefModel);
		chickenList = new JList(chickenModel);
		soupList = new JList(soupModel);
		seaFoodList = new JList(seaFoodModel); 
		sideDishList = new JList(sideDishModel);
		desertList = new JList(desertModel);
		appetizerList = new JList(appetizerModel);
		nonAlcoholicDrinksList = new JList(nonAlcoholicDrinksModel);
		alcoholicDrinksList = new JList(alcoholicDrinksModel);
		listOfOrder = new JList(modelOfOrders);

		
		// JLABELS
		// **********************************************************************

	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		eastPanel.setBorder(BorderFactory.createTitledBorder("ORDERS"));
		westPanel.setBorder(BorderFactory.createTitledBorder("MENU"));

	}

	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS
		// ***********************************************************
		mainPanel.setLayout(new GridLayout(1, 3));
		eastPanel.setLayout(new BorderLayout());
		westPanel.setLayout(new BorderLayout());
		
		
		porkPanel.setLayout(new BorderLayout());
		beefPanel.setLayout(new BorderLayout());
		chickenPanel.setLayout(new BorderLayout());
		soupPanel.setLayout(new BorderLayout());
		seaFood.setLayout(new BorderLayout());
		sideDish.setLayout(new BorderLayout());
		desert.setLayout(new BorderLayout());
		appetizer.setLayout(new BorderLayout());
		nonAlcoholicDrinks.setLayout(new BorderLayout());
		alcoholicDrinks.setLayout(new BorderLayout());
		
		centerButtonPanel.setLayout(new GridLayout(2,0));
		eastButtonPanel.setLayout(new GridLayout(1, 6));
		eastListPanel.setLayout(new BorderLayout());
		westButtonPanel.setLayout(new GridLayout(1, 1));
		westListPanel.setLayout(new BorderLayout());

		// ADDING INTO PANELS
		// *********************************************************************
		menuTabs.add("Pork", porkPanel);
		menuTabs.add("Beef",beefPanel);
		menuTabs.add("Chicken",chickenPanel);
		menuTabs.add("Soup",soupPanel);
		menuTabs.add("Sea Food",seaFood);
		menuTabs.add("Side dish",sideDish);
		menuTabs.add("Deserts",desert);
		menuTabs.add("Appetizer",appetizer);
		menuTabs.add("Non-alcoholic drinks" , nonAlcoholicDrinks);
		menuTabs.add("Alcoholic drinks" , alcoholicDrinks);
		
		porkPanel.add(porkList, BorderLayout.CENTER);
		beefPanel.add(beefList, BorderLayout.CENTER);
		chickenPanel.add(chickenList, BorderLayout.CENTER);
		soupPanel.add(soupList, BorderLayout.CENTER);
		seaFood.add(seaFoodList, BorderLayout.CENTER);
		sideDish.add(sideDishList, BorderLayout.CENTER);
		desert.add(desertList, BorderLayout.CENTER);
		appetizer.add(appetizerList, BorderLayout.CENTER);
		nonAlcoholicDrinks.add(nonAlcoholicDrinksList, BorderLayout.CENTER);
		alcoholicDrinks.add(alcoholicDrinksList, BorderLayout.CENTER);
		
		
		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);

		eastListPanel.add(listOfOrder);
		westListPanel.add(menuTabs);

		eastButtonPanel.add(orderButton);
		eastButtonPanel.add(callStaffButton);
		
		centerButtonPanel.add(plusButton);
		centerButtonPanel.add(minusButton);
		

		eastPanel.add(eastButtonPanel, BorderLayout.SOUTH);
		eastPanel.add(eastListPanel, BorderLayout.CENTER);

		westPanel.add(westButtonPanel, BorderLayout.SOUTH);
		westPanel.add(westListPanel, BorderLayout.CENTER);

		mainPanel.add(westPanel);
		mainPanel.add(centerButtonPanel);
		mainPanel.add(eastPanel);
		
		add(mainPanel, BorderLayout.CENTER);
		
		topMenuBar.add(topMenu);
		topMenu.add(menuItemEditMenu);
	}

	public static void main(String[] args) throws Exception {
		ClientGUI gui = new ClientGUI();
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}
}
