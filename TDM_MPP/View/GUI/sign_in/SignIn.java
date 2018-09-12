package GUI.sign_in;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignIn extends Stage {
	private Stage primaryStage;

	public SignIn(Stage primaryStage) {
		this.primaryStage = primaryStage;
		loadResource();
	}
//    public static void main(String[] args) {
//        Application.launch(SignIn.class, args);
//    }
    
    private void loadResource() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
			Scene scene = new Scene(root);
			this.setTitle("Login");
			this.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    
//    @Override
//    public void start(Stage stage) throws Exception {
//    	primaryStage= stage;
//        Parent root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
//        
//        stage.setTitle("Transport Dealishp Management");
//        stage.setScene(new Scene(root, 600, 400));
//        stage.show();
//    }
}
