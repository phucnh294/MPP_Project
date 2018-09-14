package GUI.Transport;

import java.io.IOException;

import Common.View;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TransportView extends View {
	
	public TransportView(Pane primaryStage) {
		super(primaryStage);
		loadResource();
	}

	private void loadResource() {
		try {
			tilePane = (GridPane) FXMLLoader.load(getClass().getResource("transport.fxml"));
			tilePane.setAlignment(Pos.CENTER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
