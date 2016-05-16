package View;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ServerGUI extends JFrame {

	

public ServerGUI() throws Exception{
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("SEP Restaurant System");
    setLayout(new BorderLayout());
    pack();
}
	
	
	
	
public static void main(String[] args) throws Exception {
	ServerGUI gui = new ServerGUI();
    gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
    gui.setVisible(true);
}	
}
