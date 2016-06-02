package View;

/**
 * @author Adam Minarik, Leonard Merva, Marek Dvoracek, Denis Drga, Marius Ungurean
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controller.Controller;
import Domain.Mediator.ModelManager;
import Domain.Mediator.RmiServerInterface;
import Domain.Model.Item;
import Domain.Model.Meal;
import Domain.Model.Order;

public class KitchenGUI extends JFrame {

	// JPANELS
	// *********************************************************************
	private JPanel mainPanel;
	private JPanel centerPanel;
	private JPanel southPanel;

	// JLABELS
	// *********************************************************************

	// JBUTTONS
	// *********************************************************************
	private JButton setAsFinished;

	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<Item> mealList;

	private DefaultListModel<Meal> mealListModel;
	private RmiServerInterface serverInterface;

	// JSCROLLPANES
	// *********************************************************************
	private JScrollPane mealListScrollPane;

	public KitchenGUI(RmiServerInterface serverInterface)
			throws Exception {
		this.serverInterface = serverInterface;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SEP Restaurant System - Kitchen");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
		addActionListeners();
		pack();
	}

	private void setComponents() {

		// JPANELS
		// **********************************************************************
		mainPanel = new JPanel();
		centerPanel = new JPanel();
		southPanel = new JPanel();

		// JBUTTONS
		// *********************************************************************

		setAsFinished = new JButton("Prepared");

		// JLISTS & DEFAULT LIST MODELS
		mealListModel = new DefaultListModel();

		mealList = new JList(mealListModel);
		mealList.setFont(new Font("Arial", Font.BOLD, 18));

		// JSCROLLPANES
		// *********************************************************************
		mealListScrollPane = new JScrollPane(mealList);

		// JLABELS
		// **********************************************************************
	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		centerPanel
				.setBorder(BorderFactory.createTitledBorder("List of meals"));

	}

	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS
		// ***********************************************************
		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout());
		southPanel.setLayout(new GridLayout(1, 1));

		// ADDING INTO PANELS
		// *********************************************************************

		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		southPanel.add(setAsFinished);

		centerPanel.add(mealListScrollPane);

		add(mainPanel, BorderLayout.CENTER);

	}

	private void addActionListeners() {
		setAsFinished.addActionListener(new setAsFinished());
	}

	class setAsFinished implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				mealListModel.removeElementAt(mealList.getSelectedIndex());
			} catch (NullPointerException | ArrayIndexOutOfBoundsException exeption) {
				JOptionPane.showMessageDialog(KitchenGUI.this,
						"First, select a meal that left the kitchen");
			}
		}

	}

	public void updateKitchen(Order order) {
		for (int i = 0; i < order.size(); i++) {
			if (order.getItem(i) instanceof Meal) {
				mealListModel.addElement((Meal) order.getItem(i));
			}
		}
	}

	public void updateKitchenRemoveItem(Item item) {
		for (int i = 0; i < mealListModel.size(); i++) {
			if (mealListModel.getElementAt(i).equals(item)) {
				mealListModel.removeElementAt(i);
				break;
			}
		}
	}
}
