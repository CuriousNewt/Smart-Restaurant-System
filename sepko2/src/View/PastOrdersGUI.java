package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import Domain.Model.Item;

import com.toedter.calendar.JDateChooser;

public class PastOrdersGUI extends JFrame {


	// JPANELS
	// *********************************************************************
	private JPanel mainPanel;
	private JPanel centerPanel;
	private JPanel northPanel;


	// JLABELS
	// *********************************************************************
	private JLabel totalDayPriceLabel;
	private JLabel amountOfItemsSoldLabel;



	// JBUTTONS
	// *********************************************************************


	// JLISTS & DEFAULT LIST MODELS
	// *********************************************************************
	private JList<Item> orderList;

	private JDateChooser calendar;

	private DefaultListModel<Item> orderListModel;


	public PastOrdersGUI() throws Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SEP Restaurant System - Past orders menu");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
		pack();
	}

	private void setComponents() {

		calendar = new JDateChooser();

		// JPANELS
		// **********************************************************************
		mainPanel = new JPanel();
		centerPanel = new JPanel();
		northPanel = new JPanel();

		// JBUTTONS
		// *********************************************************************

		
		// JLISTS & DEFAULT LIST MODELS
		orderListModel = new DefaultListModel();
		
		orderList = new JList(orderListModel);

		
		// JLABELS
		// **********************************************************************
		totalDayPriceLabel = new JLabel("Total Price: ");
		amountOfItemsSoldLabel = new JLabel("Total items sold: ");
	
	}

	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

	}

	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS
		// ***********************************************************
		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout());
		northPanel.setLayout(new GridLayout(3,1));

		

		// ADDING INTO PANELS
		// *********************************************************************
				

		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		northPanel.add(calendar);
		northPanel.add(totalDayPriceLabel);
		northPanel.add(amountOfItemsSoldLabel);
		
		centerPanel.add(orderList);
		
	
		add(mainPanel, BorderLayout.CENTER);

	}

	public static void main(String[] args) throws Exception {
		PastOrdersGUI gui = new PastOrdersGUI();
		gui.setSize(800, 800);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}
}
