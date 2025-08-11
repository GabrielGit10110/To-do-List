package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


//Java Swing Program to Add 
//JMenuBar and JButton inside the JFrame 
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GenerateView {
	
	public GenerateView() {
		super();
	}
	
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	final static JMenuBar menuBar = new JMenuBar();
	
	// Grid Implementation. For future development.
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

	public static void createSouthLabels(JPanel textPanel) {
		 // Create another panel with text
		 JLabel footer = new JLabel("Roukan 2025");
		 JLabel teste = new JLabel("TESTE");
		 textPanel.add(footer);
		 textPanel.add(teste);

	}
	
	public static void createWestLabels(JPanel textPanel) {
		 // Create another panel with text
		 JLabel nome = new JLabel("GABRIEL");
		 JLabel teste = new JLabel("TESTE");
		 textPanel.add(nome);
		 textPanel.add(teste);

	}


	public static void createButtons(JPanel buttonsPanel, JFrame frame, int i) {
		// Create a panel with a button
		List<JCheckBox> check = new ArrayList<>();
		 
		// Instantiate all the new checks
		JCheckBox newCheckBox = new JCheckBox();

		check.add(newCheckBox);

		newCheckBox.setPreferredSize(new Dimension(20, 20));
		 
		// Add action to the button
		newCheckBox.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(frame, "Button Clicked!");
			 }
		 });

		// Add the buttons at the end of the loop
		buttonsPanel.add(newCheckBox);
		buttonsPanel.add(Box.createVerticalStrut(10));
			 
	}

	public static void startWindow() {
		 // Create new frame and define title
		 JFrame frame = new JFrame("To do List");
		 
		 // Create all the panels with buttons or labels, like "divs" in HTML
		 JPanel southPanel = new JPanel();
		 JPanel eastPanel = new JPanel();
		 								// rows, columns, gap horizontal, gap vertical
		 JPanel buttonsPanel = new JPanel();
		 buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		 
		 
		 JButton addNewTask = new JButton();
		 southPanel.add(addNewTask);
		 
		 addNewTask.addActionListener(new ActionListener() {
				 int count = 0;
				 @Override
				 public void actionPerformed(ActionEvent e) {
					 System.out.println("Add new Task");
					 if (count < 15) {
						 count += 1;
						 createButtons(buttonsPanel, frame, count);
						 System.out.println(count);
					 } else if(count == 15) {
							 System.out.println("Limite atingido");
					 }

				 }
		});


		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(800, 600);
		 

		 createSouthLabels(southPanel);
		 createWestLabels(eastPanel);

		 // Set layout for the main frame
		 frame.setLayout(new BorderLayout());
		 frame.setJMenuBar(menuBar);
		 frame.add(buttonsPanel, BorderLayout.WEST);
		 frame.add(southPanel, BorderLayout.SOUTH);
		 frame.add(eastPanel, BorderLayout.EAST);
		 frame.setVisible(true);
	}
}