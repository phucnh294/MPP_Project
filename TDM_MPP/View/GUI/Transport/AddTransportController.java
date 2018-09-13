package GUI.Transport;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AddTransportController implements Initializable{
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub		
//		setUpTable();
//		loadData();
	}
	
	@FXML protected void onCreateTransport_Click(ActionEvent event) {}
	
	@FXML protected void SearchTransport_Click(ActionEvent event) {}
	@FXML protected void onClearTransport_Click(ActionEvent event) {}
	@FXML protected void onRemoveTransport_Click(ActionEvent event) {}
	@FXML protected void onEditTransport_Click(ActionEvent event) {}
}
