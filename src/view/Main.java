package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import controller.*;

public class Main {
	
	public static void main(String[] args) {
		FlatDarculaLaf.setup();
		GenerateView.startWindow();
		GenerateView.createSideMenu();
	}
}
