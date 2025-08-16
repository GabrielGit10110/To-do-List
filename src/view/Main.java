package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import controller.*;
import core.AppInjection;

public class Main {

	public static void main(String[] args) {
		TaskController taskController = AppInjection.getTaskController();
		LabelsController labelsController = AppInjection.getLabelsController();

		FlatDarculaLaf.setup();

		GenerateView gen = new GenerateView(taskController, labelsController);
		gen.startWindow();
	}
}
