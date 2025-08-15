package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;

public class FramesLabels {
	
	public FramesLabels() {
		super();
	}

	/**
	 * Method for creating the labels in the footer of the frame. <br>
	 * Needs a text panel from Java Swing JPanel
	 * @param textPanel
	 * 
	 */
	public void createSouthLabels(JPanel textPanel) {
		// Create another panel with text
		JLabel footer = new JLabel("Roukan 2025");
		textPanel.add(footer);

	}

	/**
	 * Takes care of the west side of the frame, used to put the current date. <br>
	 * Needs a text panel from java Swing JPanel.
	 * @param textPanel
	 */
	public void createDateLabels(JPanel textPanel) {
		String pattern = "dd/MM/yyyy"; // 01/feb/2025.
		SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
		String currentDate = simpleFormat.format(new Date());

		// Create another panel with text
		JLabel date = new JLabel(currentDate);
		textPanel.add(date);

	}

	/**
	 * Creates all the checkboxes in the frame dynamically.
	 * 12 boxes is the limit.
	 * @param buttonsPanel
	 * @param check
	 * @param i
	 */
	public void createButtons(JPanel buttonsPanel, List<JCheckBox> check, int i) {
		// Panel for grouping all the checks on the left of the screen dynamically
		JPanel checkPanel = new JPanel();
		checkPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align the checks on the left

		// Create a new check with a 12 tasks limit
		JCheckBox newCheckBox = new JCheckBox("" + i);
		check.add(newCheckBox);
		newCheckBox.setPreferredSize(new Dimension(20, 20));

		newCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Item " + newCheckBox.getText() + " clicado!");
			}
		});

		// Add the CheckBox
		checkPanel.add(newCheckBox);

		buttonsPanel.add(checkPanel);
		buttonsPanel.add(Box.createVerticalStrut(10));

		// Refresh the main panel
		buttonsPanel.revalidate();
		buttonsPanel.repaint();
	}
	
	public void createTextField(JPanel textPanel, List<JTextField> write, int i) {
		JPanel writePanel = new JPanel();
		writePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align the text fields on the left
		
		JTextField writeOn = new JTextField("" + i);
		writeOn.setPreferredSize(new Dimension(700, 26));

		write.add(writeOn);
		writePanel.add(writeOn);

		textPanel.add(writePanel);
		textPanel.add(Box.createVerticalStrut(10));
		
		// Refresh the main panel
		textPanel.revalidate();
		textPanel.repaint();

	}

}
