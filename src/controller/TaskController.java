package controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaskController {
	
	private final ClickController click;
	
	public TaskController() {
		this.click = new ClickController();
	}
	
	static int count = 0;

    public void addNewTaskAction(JPanel buttonsPanel, JPanel textFieldPanel, List<JCheckBox> check, 
            List<JTextField> write, JFrame frame) {
        System.out.println("Add new Task");
        if (count < 12) {
            count += 1;
            // Create a new Panel that will receive both the checkbuttons and the text fields
            JPanel[] taskPanels = createRows(check, write, count, frame);

            // Adiciona os painéis criados e o espaçador
            buttonsPanel.add(taskPanels[0]); // Painel do checkbox
            buttonsPanel.add(Box.createVerticalStrut(10));

            textFieldPanel.add(taskPanels[1]); // Painel do campo de texto
            textFieldPanel.add(Box.createVerticalStrut(10));

            // Atualiza a interface
            buttonsPanel.revalidate();
            buttonsPanel.repaint();
            textFieldPanel.revalidate();
            textFieldPanel.repaint();

            System.out.println(count);
        } else {
            System.out.println("Limite atingido");
            JOptionPane.showMessageDialog(frame, "Task limit reached...");
        }
    }


	/**
	 * Create and return a panel with a checkbox and a text field for new tasks.
	 *
	 * @param check JCheckBox List to add a new component.
	 * @param write JTextField List to add a new component.
	 * @param i     The index of the current task.
	 * @return A JPanels array containing both the checkPanel and the writePanel.
	 * 
	 */
	public JPanel[] createRows(List<JCheckBox> check, List<JTextField> write, int i, JFrame frame) {
		// ############## BUTTONS ############################# //
		// Panel for grouping all the checks on the left of the screen dynamically
		JPanel checkPanel = new JPanel();
		checkPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align the checks on the left

		// Create a new check with a 12 tasks limit
		JCheckBox newCheckBox = new JCheckBox("" + i);
		check.add(newCheckBox);
		newCheckBox.setPreferredSize(new Dimension(20, 20));

		// Handles the click action in the checkbox
		newCheckBox.addActionListener(e -> click.checkResponse(frame, i));

		// Add the CheckBox
		checkPanel.add(newCheckBox);

		// ############### TEXT FIELD ############################ //

		JPanel writePanel = new JPanel();
		writePanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align the text fields on the left

		JTextField writeOn = new JTextField("" + i);
		writeOn.setPreferredSize(new Dimension(700, 26));

		write.add(writeOn);
		writePanel.add(writeOn);

		return new JPanel[] { checkPanel, writePanel };
	}

}
