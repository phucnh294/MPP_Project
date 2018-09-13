package GUI.order;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class OrderView {
	private Pane primaryPane;
	private GridPane tilePane;

	public OrderView(Pane primaryStage) {
		this.primaryPane = primaryStage;
		loadResource();
	}
	
	private void loadResource() {
		try {
			tilePane = (GridPane) FXMLLoader.load(getClass().getResource("Order.fxml"));
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
