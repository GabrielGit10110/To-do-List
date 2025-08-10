package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;

//Java Swing Program to Add 
//JMenuBar and JButton inside the JFrame 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	final static JMenuBar menuBar = new JMenuBar();

public static void addComponents(Container pane) {
	if (RIGHT_TO_LEFT) {
		pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	} else {
		pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}

public static void createSideMenu() {
	 // Create a menu bar, top left side of the screen
     JMenu fileMenu = new JMenu("File");
     JMenuItem openItem = new JMenuItem("Open"); 
     JMenuItem exitItem = new JMenuItem("Exit");
     JMenuItem saveItem = new JMenuItem("Save");
     JMenuItem saveAsItem = new JMenuItem("Save As");
     
     // Layout Design "File" Section
     fileMenu.add(openItem);
     fileMenu.addSeparator();
     fileMenu.add(saveItem);
     fileMenu.add(saveAsItem);
     fileMenu.addSeparator();
     fileMenu.add(exitItem);
     menuBar.add(fileMenu);

}

public static void createLabels(JPanel textPanel) {
	 // Create another panel with text
     JLabel footer = new JLabel("Roukan 2025");
     JLabel teste = new JLabel("TESTE");
     textPanel.add(footer);
     textPanel.add(teste);

}

public static void startWindow() {
	 // Create new frame and define title
	 JFrame frame = new JFrame("To do List");
     JPanel textPanel = new JPanel();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(800, 600);
     
     // Create a panel with a button
     JPanel panel = new JPanel();
     JButton button = new JButton("Click Me");
     JButton check = new JButton("");
     panel.add(check);
     panel.add(button);

     // Add action to the button
     button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(frame, "Button Clicked!");
         }
     });

     createLabels(textPanel);

     // Set layout for the main frame
     frame.setLayout(new BorderLayout());
     frame.setJMenuBar(menuBar);
     frame.add(panel, BorderLayout.WEST);
     frame.add(textPanel, BorderLayout.SOUTH);
     frame.add(textPanel, BorderLayout.WEST);
     frame.setVisible(true);
}
	
 public static void main(String[] args) {
	 startWindow();
	 createSideMenu();
 }
}