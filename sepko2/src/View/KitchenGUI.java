package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import Domain.Model.Item;
import Domain.Model.Meal;
import Utility.RmiServerInterface;

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
	private RmiServerInterface serverInterface;


	public KitchenGUI(RmiServerInterface serverInterface) throws Exception {
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
	
	public void updateLists() throws RemoteException{
		mealListModel.clear();
		for(int i = 0; i < serverInterface.getController().getTables().size(); i++){
			for(int j = 0; j < serverInterface.getController().getTables().getTable(i).getOrder().size(); j++){
				Item item = serverInterface.getController().getTables().getTable(i).getOrder().getItem(j);
				if(item instanceof Meal && !item.isPrepared()){
					mealListModel.addElement(item);
				}
			}
		}
	}
	
	class setAsPrepared implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			RmiServerInterface interfaz = serverInterface;
			int index = mealList.getSelectedIndex();
			Item item = mealList.getSelectedValue();
			try {
				bezdopice : 
					for(int i = 0; i < interfaz.getController().getTables().size(); i++){
					for(int j = 0; j < interfaz.getController().getTables().getTable(i).getOrder().size(); j++){
						Item itemTemp = interfaz.getController().getTables().getTable(i).getOrder().getItem(j);
						if(item.equals(itemTemp)){
							interfaz.getController().getTables().getTable(i).getOrder().getItem(j).setAsPrepared();
							System.out.println(interfaz.getController().getTables().getTable(i).getOrder().getItem(j));
							System.out.println(interfaz.getController().getTables().getTable(i).getOrder().getItem(j).isPrepared());
							break bezdopice;
						}
					}
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			mealListModel.removeElementAt(index);
		}	
	}
	
	public void addActionListeners(){
		setAsFinished.addActionListener(new setAsPrepared());
	}
}
