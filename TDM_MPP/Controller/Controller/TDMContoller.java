package Controller;

import DataAccess.TDMDataAccess;

public class TDMContoller {
	public void printDataController() {
		System.out.println("this is Controller");
		TDMDataAccess DataAccess = new TDMDataAccess();
		DataAccess.printData();
		
	}
	
	
}