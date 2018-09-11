package GUI.sign_in;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignIn extends Application {
    
    public static void main(String[] args) {
        Application.launch(SignIn.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml_example4.fxml"));
        
        stage.setTitle("Transport Dealishp Management");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
