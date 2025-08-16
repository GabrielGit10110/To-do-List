package controller;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import view.components.*;

//Java Swing Program to Add 
//JMenuBar and JButton inside the JFrame 
import javax.swing.*;

public class GenerateView {
	
	private final JFrame frame;
	private final TaskController taskController; 
	private final LabelsController labelsController;
	private final JMenuBar menuBar;
	
	public GenerateView(TaskController taskController, LabelsController labelsController) {
		this.frame = new JFrame("To do List");
		this.taskController = taskController;
		this.labelsController = labelsController;
		this.menuBar = DropDownMenu.getInstance();
	}

	public void startWindow() {

		// Create all the panels with buttons or labels, like "divs" in HTML
		JPanel southPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		// rows, columns, gap horizontal, gap vertical
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		
		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));

		JButton addNewTask = new JButton("Adicionar Task");
		southPanel.add(addNewTask);

		// Create a panel with a button
		List<JCheckBox> check = new ArrayList<>();
		List<JTextField> write = new ArrayList<>();

		addNewTask.addActionListener(e -> taskController.addNewTaskAction(buttonsPanel, textFieldPanel,check, write, frame));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 768);

		labelsController.createSouthLabels(southPanel);
		labelsController.createDateLabels(eastPanel); 

		// Set layout for the main frame
		frame.setLayout(new BorderLayout());
		frame.setJMenuBar(menuBar);
		frame.add(buttonsPanel, BorderLayout.WEST);
		frame.add(textFieldPanel, BorderLayout.CENTER);
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.add(eastPanel, BorderLayout.EAST);
		frame.setVisible(true);
	}
}
