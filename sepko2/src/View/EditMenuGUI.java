package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditMenuGUI extends JFrame {

	private JTabbedPane menuTabs;

	// JPANELS
	// *********************************************************************
	private JPanel mainPanel;
	private JPanel eastPanel;
	private JPanel westPanel;
	private JPanel eastButtonPanel;
	private JPanel eastContentPanel;
	private JPanel westButtonPanel;
	private JPanel westTextPanel;
	private JPanel porkPanel;
	private JPanel beefPanel;
	private JPanel chickenPanel;
	private JPanel soupPanel;
	private JPanel seaFood;
	private JPanel sideDish;
	private JPanel desert;
	private JPanel starter;
	private JPanel nonAlcoholicDrinks;
	private JPanel alcoholicDrinks;
	
	

	// JLABELS
	// *********************************************************************
	private JLabel productNameLabel;
	private JLabel productDescriptionLabel;
	private JLabel productPriceLabel;
	private JLabel productAmountLabel;
	private JLabel productTypeLabel;
	
	
	private JTextField 
	
	private JComboBox productTypeComboBox;
	
	
	
	
	// JBUTTONS
	// *********************************************************************
	private JButton addButton;
	private JButton removeButton;
	

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

	public EditMenuGUI() throws Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SEP Restaurant System - Edit Menu");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
		pack();
	}

	private void setComponents() {

		menuTabs = new JTabbedPane();
		
		// JPANELS
		// **********************************************************************
		westPanel = new JPanel();
		eastPanel = new JPanel();
		eastButtonPanel = new JPanel();
		mainPanel = new JPanel();
		eastContentPanel = new JPanel();
		westButtonPanel = new JPanel();
		westTextPanel = new JPanel();
		porkPanel = new JPanel();
		beefPanel = new JPanel();
		chickenPanel = new JPanel();
		soupPanel = new JPanel();
		seaFood = new JPanel();
		sideDish = new JPanel();
		desert = new JPanel();
		starter = new JPanel();
		nonAlcoholicDrinks = new JPanel();
		alcoholicDrinks = new JPanel();

		// JBUTTONS
		// *********************************************************************
		removeButton = new JButton("Remove..");
		addButton = new JButton("Add..");

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

		
		// JLABELS
		// **********************************************************************
		productNameLabel = new JLabel("Name of product");
		productDescriptionLabel= new JLabel("Description of product");
		productPriceLabel = new JLabel("Price of product");
		productAmountLabel = new JLabel("Amount of product");
		productTypeLabel = new JLabel("Type of product");
		
	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		eastContentPanel.setBorder(BorderFactory.createTitledBorder("EDIT WINDOW"));
		menuTabs.setBorder(BorderFactory.createTitledBorder("MENU"));

	}

	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS
		// ***********************************************************
		mainPanel.setLayout(new GridLayout(1, 2));
		eastPanel.setLayout(new BorderLayout());
		westPanel.setLayout(new BorderLayout());
		
		porkPanel.setLayout(new BorderLayout());
		beefPanel.setLayout(new BorderLayout());
		chickenPanel.setLayout(new BorderLayout());
		soupPanel.setLayout(new BorderLayout());
		seaFood.setLayout(new BorderLayout());
		sideDish.setLayout(new BorderLayout());
		desert.setLayout(new BorderLayout());
		starter.setLayout(new BorderLayout());
		nonAlcoholicDrinks.setLayout(new BorderLayout());
		alcoholicDrinks.setLayout(new BorderLayout());
		
		eastContentPanel.setLayout(new GridLayout(4,1));
		
		eastButtonPanel.setLayout(new GridLayout(1, 6));
		eastContentPanel.setLayout(new BorderLayout());
		westButtonPanel.setLayout(new GridLayout(1, 1));
		westTextPanel.setLayout(new BorderLayout());

		// ADDING INTO PANELS
		// *********************************************************************
		menuTabs.add("Pork", porkPanel);
		menuTabs.add("Beef",beefPanel);
		menuTabs.add("Chicken",chickenPanel);
		menuTabs.add("Soup",soupPanel);
		menuTabs.add("Sea Food",seaFood);
		menuTabs.add("Side dish",sideDish);
		menuTabs.add("Deserts",desert);
		menuTabs.add("Starter",starter);
		menuTabs.add("Non-alcoholic drinks" , nonAlcoholicDrinks);
		menuTabs.add("Alcoholic drinks" , alcoholicDrinks);
		
		porkPanel.add(porkList, BorderLayout.CENTER);
		beefPanel.add(beefList, BorderLayout.CENTER);
		chickenPanel.add(chickenList, BorderLayout.CENTER);
		soupPanel.add(soupList, BorderLayout.CENTER);
		seaFood.add(seaFoodList, BorderLayout.CENTER);
		sideDish.add(sideDishList, BorderLayout.CENTER);
		desert.add(desertList, BorderLayout.CENTER);
		starter.add(appetizerList, BorderLayout.CENTER);
		nonAlcoholicDrinks.add(nonAlcoholicDrinksList, BorderLayout.CENTER);
		alcoholicDrinks.add(alcoholicDrinksList, BorderLayout.CENTER);
		
		
		eastContentPanel.add(productNameLabel);
		eastContentPanel.add(productDescriptionLabel);
		eastContentPanel.add(productPriceLabel);
		eastContentPanel.add(productAmountLabel);
		eastContentPanel.add(productTypeLabel);

		
		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);

		westTextPanel.add(menuTabs);

		eastButtonPanel.add(addButton);
		//eastButtonPanel.add(addButon);
		
		

		eastPanel.add(eastButtonPanel, BorderLayout.SOUTH);
		eastPanel.add(eastContentPanel, BorderLayout.CENTER);

		westButtonPanel.add(removeButton);
		
		westPanel.add(westButtonPanel, BorderLayout.SOUTH);
		westPanel.add(westTextPanel, BorderLayout.CENTER);

		
		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);
		
		add(mainPanel, BorderLayout.CENTER);
		

	}

	public static void main(String[] args) throws Exception {
		EditMenuGUI gui = new EditMenuGUI();
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}
}