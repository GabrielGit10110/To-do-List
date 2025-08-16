package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClickController {
	
    public void checkResponse(JFrame frame, int currentCheck) {
    	JOptionPane.showMessageDialog(frame, currentCheck + " Selecionado");
    }

}
