package GUI.Customer;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Customer {
	private Pane primaryPane;
	private GridPane tilePane;

	public Customer(Pane primaryStage) {
		this.primaryPane = primaryStage;
		loadResource();
	}
	
	private void loadResource() {
		try {
			tilePane = (GridPane) FXMLLoader.load(getClass().getResource("Customer.fxml"));
			tilePane.setAlignment(Pos.TOP_LEFT);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Pane getPrimaryPane() {
		return primaryPane;
	}

	public GridPane getTilePane() {
		return tilePane;
	}
	
}
