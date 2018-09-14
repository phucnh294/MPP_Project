package GUI.Customer;

import java.io.IOException;

import Common.View;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CustomerView extends View{
	
	public CustomerView(Pane primaryStage) {
		super(primaryStage);
		loadResource();
	}
	
	private void loadResource() {
		try {
			tilePane = (GridPane) FXMLLoader.load(getClass().getResource("Customer.fxml"));
			tilePane.setAlignment(Pos.CENTER);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
