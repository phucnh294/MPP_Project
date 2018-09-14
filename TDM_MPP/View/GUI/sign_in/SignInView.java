package GUI.sign_in;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignInView extends Stage {
	private Stage primaryStage;

	public SignInView(Stage primaryStage) {
		this.primaryStage = primaryStage;
		loadResource();
	}
    
    private void loadResource() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
			Scene scene = new Scene(root, 400, 300);
			this.setTitle("Login");
			this.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    

}
