package GUI.order;

import java.io.IOException;

import Common.View;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class OrderView extends View {

	public OrderView(Pane primaryStage) {
		super(primaryStage);
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

}
