package View;

import GUI.sign_in.SignInView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage;
	private static Stage loginStage;
	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("App.fxml"));
			Scene scene = new Scene(root, 1000, 700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setTitle("Transport Dealership Management");
			primaryStage.setScene(scene);
			primaryStage.setResizable(true);
			SignInView login = new SignInView(primaryStage);
			login.setResizable(false);
			loginStage = login;
			login.show();
//			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Stage getLoginStage() {
		return loginStage;
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
