package GUI.User;

import java.io.IOException;

import Common.View;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class UserView extends View {
	

	public UserView(Pane primaryStage) {
		super(primaryStage);
		loadResource();
	}
	
	public void loadResource() {
		try {
			tilePane = (GridPane) FXMLLoader.load(getClass().getResource("user.fxml"));
			tilePane.setAlignment(Pos.CENTER);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
