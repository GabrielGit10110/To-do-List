package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	 * Takes care of the west side of the frame, used to put the name of the day. <br>
	 * Needs a text panel from java Swing JPanel and the title of the day.
	 * @param textPanel
	 * @param title
	 */
	public void createWestLabels(JPanel textPanel, String title) {
		// Create another panel with text
		JLabel name = new JLabel(title);
		textPanel.add(name);

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

		// Create a new check with a 15 tasks limit
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

}
