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

	private DefaultListModel<Item> mealListModel;


	public KitchenGUI() throws Exception {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SEP Restaurant System - Kitchen");
		setLayout(new BorderLayout());
		setComponents();
		addPanelsAndLayouts();
		addBorders();
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
		
		setAsFinished = new JButton("Finished..");
		
		// JLISTS & DEFAULT LIST MODELS
		mealListModel = new DefaultListModel();
		
		mealList = new JList(mealListModel);

		
		// JLABELS
		// **********************************************************************	
	}

	
	private void addBorders() {
		mainPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		centerPanel.setBorder(BorderFactory.createTitledBorder("List of meals"));

	}

	private void addPanelsAndLayouts() {

		// SETTING OF LAYOUTS
		// ***********************************************************
		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout());
		southPanel.setLayout(new GridLayout(1,1));

		

		// ADDING INTO PANELS
		// *********************************************************************
				

		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		southPanel.add(setAsFinished);
		
		centerPanel.add(mealList);
		
	
		add(mainPanel, BorderLayout.CENTER);

	}

	public static void main(String[] args) throws Exception {
		KitchenGUI gui = new KitchenGUI();
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gui.setVisible(true);
	}
}
