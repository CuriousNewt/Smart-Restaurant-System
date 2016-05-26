package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.Controller;
import Domain.Mediator.Database;
import Domain.Model.Item;

public class EditMenuGUI extends JFrame {

	private JTabbedPane menuTabs;
	private Controller controller;
	private Database database;

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
	private JPanel pasta;
	private JPanel nonAlcoholicDrinks;
	private JPanel alcoholicDrinks;

	// JLABELS
	// *********************************************************************
	private JLabel productNameLabel;
	private JLabel productDescriptionLabel;
	private JLabel productPriceLabel;
	private JLabel productAmountLabel;
	private JLabel productTypeLabel;
	private JLabel itemTypeLabel;
	

	private JTextField productNameTextField;
	private JTextField productDescriptionTextField;
	private JTextField productPriceTextField;
	private JTextField productAmountTextField;
	private JTextField productTypeTextField;

	private JComboBox<String> productTypeComboBox;
	private JComboBox<String> productContentComboBox;
	private DefaultComboBoxModel<String> productTypeComboBoxModel;
	private DefaultComboBoxModel<String> productMealContentComboBoxModel;
	private DefaultComboBoxModel<String> productDrinkContentComboBoxModel;

	// JBUTTONS
	// *********************************************************************
	private JButton addButton;
	private JButton removeButton;

	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<Item> porkList;
	private JList<Item> beefList;
	private JList<Item> chickenList;
	private JList<Item> soupList;
	private JList<Item> seaFoodList;
	private JList<Item> sideDishList;
	private JList<Item> desertList;
	private JList<Item> appetizerList;
	private JList<Item> pastaList;
	private JList<Item> nonAlcoholicDrinksList;
	private JList<Item> alcoholicDrinksList;

	private DefaultListModel<Item> porkModel;
	private DefaultListModel<Item> beefModel;
	private DefaultListModel<Item> chickenModel;
	private DefaultListModel<Item> soupModel;
	private DefaultListModel<Item> seaFoodModel;
	private DefaultListModel<Item> sideDishModel;
	private DefaultListModel<Item> dessertModel;
	private DefaultListModel<Item> starterModel;
	private DefaultListModel<Item> pastaModel;
	private DefaultListModel<Item> nonAlcoholicDrinksModel;
	private DefaultListModel<Item> alcoholicDrinksModel;

	public EditMenuGUI(Database database, Controller controller) throws Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SEP Restaurant System - Edit Menu");
		this.controller = controller;
		this.database = database;
		setLayout(new BorderLayout());
		setComponents();
		fillFirstTab();
		addPanelsAndLayouts();
		addBorders();
		addActionListeners();
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
		pasta = new JPanel();
		nonAlcoholicDrinks = new JPanel();
		alcoholicDrinks = new JPanel();

		// JBUTTONS
		// *********************************************************************
		removeButton = new JButton("Remove..");
		addButton = new JButton("Add..");

		// JLISTS & DEFAULT LIST MODELS
		porkModel = new DefaultListModel<Item>();
		beefModel = new DefaultListModel<Item>();
		chickenModel = new DefaultListModel<Item>();
		soupModel = new DefaultListModel<Item>();
		seaFoodModel = new DefaultListModel<Item>();
		sideDishModel = new DefaultListModel<Item>();
		dessertModel = new DefaultListModel<Item>();
		starterModel = new DefaultListModel<Item>();
		pastaModel = new DefaultListModel<Item>();
		nonAlcoholicDrinksModel = new DefaultListModel<Item>();
		alcoholicDrinksModel = new DefaultListModel<Item>();

		porkList = new JList(porkModel);
		beefList = new JList(beefModel);
		chickenList = new JList(chickenModel);
		soupList = new JList(soupModel);
		seaFoodList = new JList(seaFoodModel);
		sideDishList = new JList(sideDishModel);
		desertList = new JList(dessertModel);
		appetizerList = new JList(starterModel);
		pastaList = new JList(pastaModel);
		nonAlcoholicDrinksList = new JList(nonAlcoholicDrinksModel);
		alcoholicDrinksList = new JList(alcoholicDrinksModel);

		// JLABELS
		// **********************************************************************
		productNameLabel = new JLabel("Name of product:");
		productDescriptionLabel = new JLabel("Description of product:");
		productPriceLabel = new JLabel("Price of product:");
		productAmountLabel = new JLabel("Amount of product:");
		itemTypeLabel = new JLabel("Type of item:");
		productTypeLabel = new JLabel("Type of Product:");
		
		

		productNameTextField = new JTextField();
		productDescriptionTextField = new JTextField();
		productPriceTextField = new JTextField();
		productAmountTextField = new JTextField();
		productTypeComboBoxModel = new DefaultComboBoxModel<String>(
				(new String[] { "Meal", "Drink" }));
		productMealContentComboBoxModel = new DefaultComboBoxModel<String>(
				new String[] { "Starter", "Soup", "Pork", "Beef", "Chicken", "Pasta", "Sea Food",
						"Side dish", "Dessert"});

		productDrinkContentComboBoxModel = new DefaultComboBoxModel<String>(
				new String[] { "Non-alcoholic", "Alcoholic" });

		productTypeComboBox = new JComboBox<String>(productTypeComboBoxModel);

		productContentComboBox = new JComboBox<String>();
		if(productTypeComboBox.getSelectedItem().equals("Meal")){
			productContentComboBox.setModel(productMealContentComboBoxModel);
		}
		else productContentComboBox.setModel(productDrinkContentComboBoxModel);
	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		eastContentPanel.setBorder(BorderFactory
				.createTitledBorder("EDIT WINDOW"));
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
		pasta.setLayout(new BorderLayout());

		eastContentPanel.setLayout(new GridLayout(7, 2));

		eastButtonPanel.setLayout(new GridLayout(1, 6));
		westButtonPanel.setLayout(new GridLayout(1, 1));
		westTextPanel.setLayout(new BorderLayout());

		// ADDING INTO PANELS
		// *********************************************************************
		menuTabs.add("Starter", starter);
		menuTabs.add("Soup", soupPanel);
		menuTabs.add("Pork", porkPanel);
		menuTabs.add("Beef", beefPanel);
		menuTabs.add("Chicken", chickenPanel);
		menuTabs.add("Pasta", pasta);
		menuTabs.add("Sea Food", seaFood);
		menuTabs.add("Side dish", sideDish);
		menuTabs.add("Deserts", desert);
		menuTabs.add("Non-alcoholic drinks", nonAlcoholicDrinks);
		menuTabs.add("Alcoholic drinks", alcoholicDrinks);

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
		pasta.add(pastaList, BorderLayout.CENTER);
		
		eastContentPanel.add(productNameLabel);
		eastContentPanel.add(productNameTextField);
		eastContentPanel.add(productDescriptionLabel);
		eastContentPanel.add(productDescriptionTextField);
		eastContentPanel.add(productPriceLabel);
		eastContentPanel.add(productPriceTextField);
		eastContentPanel.add(productAmountLabel);
		eastContentPanel.add(productAmountTextField);
		eastContentPanel.add(itemTypeLabel);
		eastContentPanel.add(productTypeComboBox);
		eastContentPanel.add(productTypeLabel);
		eastContentPanel.add(productContentComboBox);
		

		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);

		westTextPanel.add(menuTabs);

		eastButtonPanel.add(addButton);

		eastPanel.add(eastButtonPanel, BorderLayout.SOUTH);
		eastPanel.add(eastContentPanel, BorderLayout.CENTER);

		westButtonPanel.add(removeButton);

		westPanel.add(westButtonPanel, BorderLayout.SOUTH);
		westPanel.add(westTextPanel, BorderLayout.CENTER);

		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);

		add(mainPanel, BorderLayout.CENTER);

	}
	
	public void addActionListeners(){
		menuTabs.addChangeListener(new MenuByType());
	}
	
	class MenuByType implements ChangeListener {
		public void stateChanged(ChangeEvent arg0) {

			JTabbedPane sourceTabbedPane = (JTabbedPane) arg0.getSource();
			int index = sourceTabbedPane.getSelectedIndex();
			String temp = sourceTabbedPane.getTitleAt(index).toLowerCase();

			switch (temp) {
			case "pasta":
				pastaModel.clear();
				for (int i = 0; i < controller.showMenuByType("pasta").size(); i++) {
					pastaModel.addElement(controller.showMenuByType("pasta")
							.get(i));
				}
				break;

			case "pork":
				porkModel.clear();
				for (int i = 0; i < controller.showMenuByType("pork").size(); i++) {
					porkModel.addElement(controller.showMenuByType("pork").get(
							i));
				}
				break;

			case "chicken":
				chickenModel.clear();
				for (int i = 0; i < controller.showMenuByType("chicken").size(); i++) {
					chickenModel.addElement(controller
							.showMenuByType("chicken").get(i));
				}
				break;

			case "starter":
				starterModel.clear();
				for (int i = 0; i < controller.showMenuByType("starter").size(); i++) {
					starterModel.addElement(controller
							.showMenuByType("starter").get(i));
				}
				break;

			case "beef":
				beefModel.clear();
				for (int i = 0; i < controller.showMenuByType("beef").size(); i++) {
					beefModel.addElement(controller.showMenuByType("beef").get(
							i));
				}
				break;

			case "desserts":
				dessertModel.clear();
				for (int i = 0; i < controller.showMenuByType("dessert").size(); i++) {
					dessertModel.addElement(controller
							.showMenuByType("dessert").get(i));
				}
				break;

			case "soup":
				soupModel.clear();
				for (int i = 0; i < controller.showMenuByType("soups").size(); i++) {
					soupModel.addElement(controller.showMenuByType("soups")
							.get(i));
				}
				break;

			case "sea food":
				seaFoodModel.clear();
				for (int i = 0; i < controller.showMenuByType("seafood").size(); i++) {
					seaFoodModel.addElement(controller
							.showMenuByType("seafood").get(i));
				}
				break;

			case "side dish":
				sideDishModel.clear();
				for (int i = 0; i < controller.showMenuByType("sidedish")
						.size(); i++) {
					sideDishModel.addElement(controller.showMenuByType(
							"sidedish").get(i));
				}
				break;

			case "alcoholic drinks":
				alcoholicDrinksModel.clear();
				for (int i = 0; i < controller.showMenuByType("alcoholic")
						.size(); i++) {
					alcoholicDrinksModel.addElement(controller.showMenuByType(
							"alcoholic").get(i));
				}
				break;

			case "non-alcoholic drinks":
				nonAlcoholicDrinksModel.clear();
				for (int i = 0; i < controller.showMenuByType("nonalcoholic")
						.size(); i++) {
					nonAlcoholicDrinksModel.addElement(controller
							.showMenuByType("nonalcoholic").get(i));
				}
				break;

			default:
				System.out.println("OUHA SOMETHING WENT WRONG");
				break;
			}
		}
	}
	
	private void fillFirstTab(){
		starterModel.clear();
		for (int i = 0; i < controller.showMenuByType("starter").size(); i++) {
			starterModel.addElement(controller
					.showMenuByType("starter").get(i));
		}
	}
}