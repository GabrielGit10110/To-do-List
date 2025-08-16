package view.components;

import javax.swing.*;

public class DropDownMenu {

	// Create the menu Bar
	private final static JMenuBar menuBar = dropDownMenu();
	
	public static JMenuBar dropDownMenu() {
		// Create a menu bar, top left side of the screen
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");

		// Layout Design "File" Section
		fileMenu.add(new JMenuItem("openItem"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Save"));
		fileMenu.add(new JMenuItem("Save As"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("exitItem"));
		bar.add(fileMenu);

		return bar;
	}
	
	public static JMenuBar getInstance() {
		return menuBar;
	}
}
