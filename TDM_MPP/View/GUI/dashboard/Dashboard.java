package GUI.dashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dashboard extends Application {
    
    public static void main(String[] args) {
        Application.launch(Dashboard.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("dash_new.fxml"));
        
        stage.setTitle("Transport Dealishp Management");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
