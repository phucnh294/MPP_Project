package GUI.dashboard;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Dashboard extends Stage {
	private Stage primaryStage;
   
    public Dashboard(Stage primaryStage) {
		this.primaryStage = primaryStage;
		loadResource();
	}
  
    private void loadResource() {
		try {
			Parent grid = FXMLLoader.load(getClass().getResource("dash_new.fxml"));
			Scene scene = new Scene(grid);
			this.setTitle("Dashboard");
			this.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
