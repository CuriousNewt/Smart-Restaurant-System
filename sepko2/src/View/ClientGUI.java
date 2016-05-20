package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Controller.Controller;
import Domain.Model.Item;
import Domain.Model.Order;

public class ClientGUI extends JFrame {

	private JMenuBar topMenuBar;
	private JMenu topMenu;
	private JMenuItem menuItemEditMenu;
	private JTabbedPane menuTabs;
	private Controller controller;
	private double totalPrice;

	private final int ID;

	// JPANELS //
	// *********************************************************************
	private JPanel mainPanel;

	private JPanel eastPanel;
	private JPanel westPanel;

	private JPanel eastButtonPanel;
	private JPanel eastListPanel;
	private JPanel westButtonPanel;
	private JPanel westListPanel;
	private JPanel centerButtonPanel;
	private JPanel centerPanel;
	private JPanel plusButtonPanel;
	private JPanel priceMiddlePanel;

	private JPanel starter;
	private JPanel soupPanel;
	private JPanel porkPanel;
	private JPanel beefPanel;
	private JPanel chickenPanel;
	private JPanel pastaPanel;
	private JPanel seaFood;
	private JPanel sideDish;
	private JPanel desert;
	private JPanel nonAlcoholicDrinks;
	private JPanel alcoholicDrinks;

	private JPanel minusButtonPanel;

	// JLABELS //
	// *********************************************************************

	private JLabel price;

	// JBUTTONS //
	// *********************************************************************

	private JButton plusButton;
	private JButton orderButton;
	private JButton minusButton;
	private JButton callStaffButton;

	// JLISTS & DEFAULT LIST MODELS //
	// *********************************************************************

	private JList<Item> appetizerList;
	private JList<Item> soupList;
	private JList<Item> porkList;
	private JList<Item> beefList;
	private JList<Item> chickenList;
	private JList<Item> pastaList;
	private JList<Item> seaFoodList;
	private JList<Item> sideDishList;
	private JList<Item> desertList;
	private JList<Item> nonAlcoholicDrinksList;
	private JList<Item> alcoholicDrinksList;

	private JList<Item> listOfOrder;

	private DefaultListModel<Item> starterModel;
	private DefaultListModel<Item> soupModel;
	private DefaultListModel<Item> porkModel;
	private DefaultListModel<Item> beefModel;
	private DefaultListModel<Item> chickenModel;
	private DefaultListModel<Item> pastaModel;
	private DefaultListModel<Item> seaFoodModel;
	private DefaultListModel<Item> sideDishModel;
	private DefaultListModel<Item> dessertModel;
	private DefaultListModel<Item> nonAlcoholicDrinksModel;
	private DefaultListModel<Item> alcoholicDrinksModel;

	private DefaultListModel<Item> modelOfOrders;

	public ClientGUI(Controller controller, int ID) throws Exception {
		this.controller = controller;
		this.ID = ID;

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(topMenuBar);
		setTitle("SEP Restaurant System");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
		addActionListeners();
		plusButton.setPreferredSize(new Dimension(200, 125));
		minusButton.setPreferredSize(new Dimension(200, 125));
		pack();
	}

	private void setComponents() {
		totalPrice = 0;

		// TOP MENU BAR //
		// **********************************************************************

		topMenuBar = new JMenuBar();
		topMenu = new JMenu("Edit");
		menuItemEditMenu = new JMenuItem("Edit menu..");
		menuTabs = new JTabbedPane();

		// JPANELS //
		// **********************************************************************

		westPanel = new JPanel();
		eastPanel = new JPanel();
		eastButtonPanel = new JPanel();
		mainPanel = new JPanel();
		eastListPanel = new JPanel();
		westButtonPanel = new JPanel();
		westListPanel = new JPanel();
		centerButtonPanel = new JPanel();
		centerPanel = new JPanel();
		plusButtonPanel = new JPanel();
		priceMiddlePanel = new JPanel();

		starter = new JPanel();
		soupPanel = new JPanel();
		porkPanel = new JPanel();
		beefPanel = new JPanel();
		chickenPanel = new JPanel();
		pastaPanel = new JPanel();
		seaFood = new JPanel();
		sideDish = new JPanel();
		desert = new JPanel();
		nonAlcoholicDrinks = new JPanel();
		alcoholicDrinks = new JPanel();

		minusButtonPanel = new JPanel();

		// JBUTTONS //
		// *********************************************************************

		minusButton = new JButton("-");
		plusButton = new JButton("+");
		orderButton = new JButton("Order");
		callStaffButton = new JButton("Call saff");

		// JLISTS & DEFAULT LIST MODELS

		starterModel = new DefaultListModel<Item>();
		soupModel = new DefaultListModel<Item>();
		porkModel = new DefaultListModel<Item>();
		beefModel = new DefaultListModel<Item>();
		chickenModel = new DefaultListModel<Item>();
		pastaModel = new DefaultListModel<Item>();
		seaFoodModel = new DefaultListModel<Item>();
		sideDishModel = new DefaultListModel<Item>();
		dessertModel = new DefaultListModel<Item>();
		nonAlcoholicDrinksModel = new DefaultListModel<Item>();
		alcoholicDrinksModel = new DefaultListModel<Item>();

		modelOfOrders = new DefaultListModel<Item>();

		appetizerList = new JList(starterModel);
		soupList = new JList(soupModel);
		porkList = new JList(porkModel);
		beefList = new JList(beefModel);
		chickenList = new JList(chickenModel);
		pastaList = new JList(pastaModel);
		seaFoodList = new JList(seaFoodModel);
		sideDishList = new JList(sideDishModel);
		desertList = new JList(dessertModel);
		nonAlcoholicDrinksList = new JList(nonAlcoholicDrinksModel);
		alcoholicDrinksList = new JList(alcoholicDrinksModel);

		listOfOrder = new JList(modelOfOrders);

		// JLABELS //
		// **********************************************************************

		price = new JLabel("Total price: 0 Kr. ");
	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		eastPanel.setBorder(BorderFactory.createTitledBorder("ORDERS"));
		menuTabs.setBorder(BorderFactory.createTitledBorder("MENU"));
		minusButtonPanel.setBorder(BorderFactory
				.createEmptyBorder(100, 0, 0, 0));
		priceMiddlePanel.setBorder(BorderFactory
				.createEmptyBorder(100, 0, 0, 0));
	}

	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS //
		// ***********************************************************

		mainPanel.setLayout(new GridLayout(1, 2));
		eastPanel.setLayout(new BorderLayout());
		westPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout());

		starter.setLayout(new BorderLayout());
		soupPanel.setLayout(new BorderLayout());
		porkPanel.setLayout(new BorderLayout());
		beefPanel.setLayout(new BorderLayout());
		chickenPanel.setLayout(new BorderLayout());
		pastaPanel.setLayout(new BorderLayout());
		seaFood.setLayout(new BorderLayout());
		sideDish.setLayout(new BorderLayout());
		desert.setLayout(new BorderLayout());
		nonAlcoholicDrinks.setLayout(new BorderLayout());
		alcoholicDrinks.setLayout(new BorderLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		centerButtonPanel.setLayout(new GridBagLayout());
		eastButtonPanel.setLayout(new GridLayout(1, 6));
		eastListPanel.setLayout(new BorderLayout());
		westButtonPanel.setLayout(new GridLayout(1, 1));
		westListPanel.setLayout(new BorderLayout());

		// ADDING INTO PANELS //
		// *********************************************************************

		menuTabs.add("Starter", starter);
		menuTabs.add("Soup", soupPanel);
		menuTabs.add("Pork", porkPanel);
		menuTabs.add("Beef", beefPanel);
		menuTabs.add("Chicken", chickenPanel);
		menuTabs.add("Pasta", pastaPanel);
		menuTabs.add("Sea Food", seaFood);
		menuTabs.add("Side dish", sideDish);
		menuTabs.add("Desserts", desert);
		menuTabs.add("Non-alcoholic drinks", nonAlcoholicDrinks);
		menuTabs.add("Alcoholic drinks", alcoholicDrinks);
		starter.add(appetizerList, BorderLayout.CENTER);
		soupPanel.add(soupList, BorderLayout.CENTER);
		porkPanel.add(porkList, BorderLayout.CENTER);
		beefPanel.add(beefList, BorderLayout.CENTER);
		chickenPanel.add(chickenList, BorderLayout.CENTER);
		pastaPanel.add(pastaList, BorderLayout.CENTER);
		seaFood.add(seaFoodList, BorderLayout.CENTER);
		sideDish.add(sideDishList, BorderLayout.CENTER);
		desert.add(desertList, BorderLayout.CENTER);
		nonAlcoholicDrinks.add(nonAlcoholicDrinksList, BorderLayout.CENTER);
		alcoholicDrinks.add(alcoholicDrinksList, BorderLayout.CENTER);

		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);
		eastListPanel.add(listOfOrder);
		westListPanel.add(menuTabs);
		eastButtonPanel.add(orderButton);
		eastButtonPanel.add(callStaffButton);
		minusButtonPanel.add(minusButton);
		priceMiddlePanel.add(price);
		plusButtonPanel.add(plusButton);

		centerButtonPanel.add(plusButtonPanel, gbc);
		centerButtonPanel.add(priceMiddlePanel, gbc);
		centerButtonPanel.add(minusButtonPanel, gbc);

		eastPanel.add(eastButtonPanel, BorderLayout.SOUTH);
		eastPanel.add(eastListPanel, BorderLayout.CENTER);
		westPanel.add(westButtonPanel, BorderLayout.SOUTH);
		westPanel.add(westListPanel, BorderLayout.CENTER);
		westPanel.add(centerButtonPanel, BorderLayout.EAST);
		mainPanel.add(westPanel);
		mainPanel.add(eastPanel);
		add(mainPanel, BorderLayout.CENTER);
		topMenuBar.add(topMenu);
		topMenu.add(menuItemEditMenu);
	}

	// ADDING FUNCTIONS //
	// *********************************************************************

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

	class plusItemToOrder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel tab = (JPanel) menuTabs.getSelectedComponent();
			JList list = (JList) tab.getComponent(0);
			Item selectedElement = (Item) list.getSelectedValue();
			modelOfOrders.addElement(selectedElement);
			incrementPrice(selectedElement);
		}

	}

	class minusItemFromOrder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Item selectedElement = (Item) listOfOrder.getSelectedValue();
			modelOfOrders.removeElement(selectedElement);
			decrementPrice(selectedElement);
		}
	}

	class createOrder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Order order = new Order(ID);
			for (int i = 0; i < modelOfOrders.size(); i++) {
				order.addItem(modelOfOrders.getElementAt(i));
			}

			System.out.println(order.show());
			modelOfOrders.clear();
			JOptionPane.showMessageDialog(ClientGUI.this,
					"Order successful! \n" + "Total price: " + totalPrice
							+ " Kr.");
		}
	}

	public void incrementPrice(Item item) {
		totalPrice += item.getPrice();
		price.setText("Total price: " + totalPrice + " Kr.");
	}

	public void decrementPrice(Item item) {
		totalPrice -= item.getPrice();
		price.setText("Total price: " + totalPrice + " Kr.");
	}

	public void addActionListeners() {

		menuTabs.addChangeListener(new MenuByType());
		plusButton.addActionListener(new plusItemToOrder());
		minusButton.addActionListener(new minusItemFromOrder());
		orderButton.addActionListener(new createOrder());

		// Filling up pork on start because its first selected tab

		for (int i = 0; i < controller.showMenuByType("pork").size(); i++) {
			porkModel.addElement(controller.showMenuByType("pork").get(i));
		}
	}
}
