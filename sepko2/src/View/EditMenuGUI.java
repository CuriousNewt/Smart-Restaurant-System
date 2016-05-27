package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

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
import Domain.Model.Drink;
import Domain.Model.Item;
import Domain.Model.Meal;
import Utility.RmiServerInterface;

public class EditMenuGUI extends JFrame {

	private JTabbedPane menuTabs;
	private Controller controller;
	private Database database;
	private RmiServerInterface rmiService;

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
	private JButton editButton;

	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<Item> porkList;
	private JList<Item> beefList;
	private JList<Item> chickenList;
	private JList<Item> soupList;
	private JList<Item> seaFoodList;
	private JList<Item> sideDishList;
	private JList<Item> dessertList;
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

	public EditMenuGUI(Database database, Controller controller,
			RmiServerInterface rmiService) throws Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SEP Restaurant System - Edit Menu");
		this.controller = controller;
		this.database = database;
		this.rmiService = rmiService;
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
		editButton = new JButton("Edit..");

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
		dessertList = new JList(dessertModel);
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
				new String[] { "Starter", "Soup", "Pork", "Beef", "Chicken",
						"Pasta", "Sea Food", "Side dish", "Dessert" });

		productDrinkContentComboBoxModel = new DefaultComboBoxModel<String>(
				new String[] { "Non-alcoholic", "Alcoholic" });

		productTypeComboBox = new JComboBox<String>(productTypeComboBoxModel);

		productContentComboBox = new JComboBox<String>();
		if (productTypeComboBox.getSelectedItem().equals("Meal")) {
			productContentComboBox.setModel(productMealContentComboBoxModel);
		} else
			productContentComboBox.setModel(productDrinkContentComboBoxModel);
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
		westButtonPanel.setLayout(new GridLayout(1, 2));
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
		menuTabs.add("Desserts", desert);
		menuTabs.add("Non-alcoholic drinks", nonAlcoholicDrinks);
		menuTabs.add("Alcoholic drinks", alcoholicDrinks);

		porkPanel.add(porkList, BorderLayout.CENTER);
		beefPanel.add(beefList, BorderLayout.CENTER);
		chickenPanel.add(chickenList, BorderLayout.CENTER);
		soupPanel.add(soupList, BorderLayout.CENTER);
		seaFood.add(seaFoodList, BorderLayout.CENTER);
		sideDish.add(sideDishList, BorderLayout.CENTER);
		desert.add(dessertList, BorderLayout.CENTER);
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
		westButtonPanel.add(editButton);

		westPanel.add(westButtonPanel, BorderLayout.SOUTH);
		westPanel.add(westTextPanel, BorderLayout.CENTER);

		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);

		add(mainPanel, BorderLayout.CENTER);

	}

	public void addActionListeners() {
		menuTabs.addChangeListener(new MenuByType());
		editButton.addActionListener(new addInfoToEditMenu());
		removeButton.addActionListener(new removeFromMenu());
		addButton.addActionListener(new addToMenu());

	}

	public void getMenuByType() {
		pastaModel.clear();
		for (int i = 0; i < controller.showMenuByType("pasta").size(); i++) {
			pastaModel.addElement(controller.showMenuByType("pasta").get(i));
		}

		porkModel.clear();
		for (int i = 0; i < controller.showMenuByType("pork").size(); i++) {
			porkModel.addElement(controller.showMenuByType("pork").get(i));
		}

		chickenModel.clear();
		for (int i = 0; i < controller.showMenuByType("chicken").size(); i++) {
			chickenModel
					.addElement(controller.showMenuByType("chicken").get(i));
		}
		starterModel.clear();
		for (int i = 0; i < controller.showMenuByType("starter").size(); i++) {
			starterModel
					.addElement(controller.showMenuByType("starter").get(i));
		}

		beefModel.clear();
		for (int i = 0; i < controller.showMenuByType("beef").size(); i++) {
			beefModel.addElement(controller.showMenuByType("beef").get(i));
		}

		dessertModel.clear();
		for (int i = 0; i < controller.showMenuByType("dessert").size(); i++) {
			dessertModel
					.addElement(controller.showMenuByType("dessert").get(i));
		}

		soupModel.clear();
		for (int i = 0; i < controller.showMenuByType("soups").size(); i++) {
			soupModel.addElement(controller.showMenuByType("soups").get(i));
		}

		seaFoodModel.clear();
		for (int i = 0; i < controller.showMenuByType("seafood").size(); i++) {
			seaFoodModel
					.addElement(controller.showMenuByType("seafood").get(i));
		}

		sideDishModel.clear();
		for (int i = 0; i < controller.showMenuByType("sidedish").size(); i++) {
			sideDishModel.addElement(controller.showMenuByType("sidedish").get(
					i));
		}

		alcoholicDrinksModel.clear();
		for (int i = 0; i < controller.showMenuByType("alcoholic").size(); i++) {
			alcoholicDrinksModel.addElement(controller.showMenuByType(
					"alcoholic").get(i));
		}

		nonAlcoholicDrinksModel.clear();
		for (int i = 0; i < controller.showMenuByType("nonalcoholic").size(); i++) {
			nonAlcoholicDrinksModel.addElement(controller.showMenuByType(
					"nonalcoholic").get(i));
		}

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
	public void removeSelectedItemFromMenu(Item selectedElement) {
		try {
			database.removeFromMenu(selectedElement);
			controller.clearMenu();
			database.getMenu();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		getMenuByType();
		try {
			rmiService.updateMenuOfClients();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	class removeFromMenu implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel tab = (JPanel) menuTabs.getSelectedComponent();
			JList list = (JList) tab.getComponent(0);
			Item selectedElement = (Item) list.getSelectedValue();
			removeSelectedItemFromMenu(selectedElement);
		}

	}

	class addInfoToEditMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel tab = (JPanel) menuTabs.getSelectedComponent();
			JList list = (JList) tab.getComponent(0);
			Item selectedElement = (Item) list.getSelectedValue();
			productNameTextField.setText(selectedElement.getName());
			productDescriptionTextField.setText(selectedElement
					.getDescription());
			productPriceTextField.setText("" + selectedElement.getPrice());
			productAmountTextField.setText("" + (int) selectedElement.getAmount());
			if (selectedElement instanceof Meal) {
				productTypeComboBox.setSelectedIndex(0);
				productContentComboBox
						.setModel(productMealContentComboBoxModel);
				String temp = selectedElement.getType();
				switch (temp) {
				case "starter": productContentComboBox.setSelectedIndex(0); break;
				case "soups": productContentComboBox.setSelectedIndex(1); break;
				case "dessert": productContentComboBox.setSelectedIndex(8); break;
				case "beef":productContentComboBox.setSelectedIndex(3); break;
				case "chicken": productContentComboBox.setSelectedIndex(4); break;
				case "pork": productContentComboBox.setSelectedIndex(2); break;
				case "pasta": productContentComboBox.setSelectedIndex(5); break;
				case "seafood": productContentComboBox.setSelectedIndex(6); break;
				case "sidedish": productContentComboBox.setSelectedIndex(7); break;
				}

			} else {
				productTypeComboBox.setSelectedIndex(1);
				productContentComboBox
						.setModel(productDrinkContentComboBoxModel);
				if (selectedElement.getType().equals("nonalcoholic")) {
					productContentComboBox.setSelectedIndex(0);
				} else {
					productContentComboBox.setSelectedIndex(1);
				}

			}
			removeSelectedItemFromMenu(selectedElement);
			
		}

	}
	
	class addToMenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = productNameTextField.getText();
			String description = productDescriptionTextField.getText();
			double price = Double.parseDouble(productPriceTextField.getText());
			if(productTypeComboBox.getSelectedIndex() == 0) {
				int amount = Integer.parseInt(productAmountTextField.getText());
				String type = (String) productContentComboBox.getSelectedItem();
				switch(type) {
					case "Starter": type = "starter"; break;
					case "Soup": type = "soups"; break;
					case "Pork": type = "pork"; break;
					case "Beef": type = "beef"; break;
					case "Chicken": type = "chicken"; break;
					case "Pasta": type = "pasta"; break;
					case "Sea Food": type = "seafood"; break;
					case "Side dish": type = "sidedish"; break;
					case "Dessert": type = "dessert"; break;
				}
				Meal meal = new Meal(name, description, price, amount, type);
				try {
					database.addToMenu(meal);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				double amount = Double.parseDouble(productAmountTextField.getText());
				String type = (String) productContentComboBox.getSelectedItem();
				Drink drink = new Drink(name, description, price, amount, type);
				if(type.equals("Non-alcoholic")) {
					type = "nonalcoholic";
				} else {
					type = "alcoholic";
				}
				try {
					database.addToMenu(drink);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			try {
				controller.clearMenu();
				database.getMenu();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			getMenuByType();
			try {
				rmiService.updateMenuOfClients();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
	}

	private void fillFirstTab() {

		starterModel.clear();
		for (int i = 0; i < controller.showMenuByType("starter").size(); i++) {
			starterModel
					.addElement(controller.showMenuByType("starter").get(i));
		}
	}
}
