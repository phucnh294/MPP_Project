package View;

import Controller.TDMContoller;
import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
		System.out.println("this is main class for view");
		TDMContoller tdmContoller = new TDMContoller();
		
		tdmContoller.printDataController();
	}
}
