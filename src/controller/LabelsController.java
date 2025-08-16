package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class LabelsController {

	/**
	 * Method for creating the labels in the footer of the frame. <br>
	 * Needs a text panel from Java Swing JPanel
	 * 
	 * @param textPanel
	 * 
	 */
	public void createSouthLabels(JPanel textPanel) {
		// Create another panel with text
		JLabel footer = new JLabel("Roukan 2025");
		textPanel.add(footer);

	}

	/**
	 * Generate a label with the current date. <br>
	 *
	 * @param textPanel to add in the UI
	 */
	public void createDateLabels(JPanel textPanel) {
		String pattern = "dd/MM/yyyy"; // 01/feb/2025.
		SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
		String currentDate = simpleFormat.format(new Date());

		// Create another panel with text
		JLabel date = new JLabel(currentDate);
		textPanel.add(date);
	}
}
