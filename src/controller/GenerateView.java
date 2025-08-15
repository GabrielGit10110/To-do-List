package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//Java Swing Program to Add 
//JMenuBar and JButton inside the JFrame 
import javax.swing.*;

public class GenerateView {

	final static FramesLabels fl = new FramesLabels();
	final static JMenuBar menuBar = new JMenuBar();

	public GenerateView() {
		super();
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


	public static void startWindow() {
		// Create new frame and define title
		JFrame frame = new JFrame("To do List");

		// Create all the panels with buttons or labels, like "divs" in HTML
		JPanel southPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		// rows, columns, gap horizontal, gap vertical
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

		JButton addNewTask = new JButton("Adicionar Task");
		southPanel.add(addNewTask);

		// Create a panel with a button
		List<JCheckBox> check = new ArrayList<>();

		addNewTask.addActionListener(new ActionListener() {
			int count = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add new Task");
				if (count < 12) {
					count += 1;
					fl.createButtons(buttonsPanel, check, count);
					System.out.println(count);
				} else if (count >= 12) {
					System.out.println("Limite atingido");
					JOptionPane.showMessageDialog(frame, "Task limit reached...");
				}

			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		
		String title = "TESTE";

		fl.createSouthLabels(southPanel);
		fl.createWestLabels(eastPanel, title);

		// Set layout for the main frame
		frame.setLayout(new BorderLayout());
		frame.setJMenuBar(menuBar);
		frame.add(buttonsPanel, BorderLayout.WEST);
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.add(eastPanel, BorderLayout.EAST);
		frame.setVisible(true);
	}
}
