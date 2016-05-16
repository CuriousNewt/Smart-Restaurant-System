package View;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class ServerGUI extends JFrame {

private JPanel eastPanel;
private JPanel westPanel;
private JPanel westPanelJListPanel;
private JButton tablesSelectButton;
private JList<String> listOfTables;
private DefaultListModel tablesModel;
private JSplitPane splitPane;


public ServerGUI() throws Exception{
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("SEP Restaurant System");
    setLayout(new BorderLayout());
    setComponents();
    addPanelsAndLayouts();
    pack();
}
	



private void setComponents(){
	westPanel = new JPanel();
	eastPanel = new JPanel();
	westPanelJListPanel = new JPanel(); 
	splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, westPanel,eastPanel);
	tablesSelectButton = new JButton();
	tablesModel = new DefaultListModel();
	listOfTables = new JList<String>(tablesModel);
}

private void addPanelsAndLayouts(){
	
	
	westPanelJListPanel.setLayout(new BorderLayout());
	eastPanel.setLayout(new BorderLayout());
	westPanel.setLayout(new BorderLayout());
	
	westPanelJListPanel.add(listOfTables, BorderLayout.CENTER);
	
	eastPanel.add(westPanelJListPanel, BorderLayout.CENTER);
	eastPanel.add(tablesSelectButton, BorderLayout.SOUTH);
	
	add(splitPane, BorderLayout.CENTER);
	splitPane.setDividerLocation(900);;
	
}
	
	
public static void main(String[] args) throws Exception {
	ServerGUI gui = new ServerGUI();
    gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
    gui.setVisible(true);
}	
}
