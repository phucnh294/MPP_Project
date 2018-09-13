package GUI.order;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class OrderController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML protected void onCreateOrder_Click(ActionEvent event) {}	
	@FXML protected void onSearchOrder_Click(ActionEvent event) {}
	@FXML protected void onClearOrder_Click(ActionEvent event) {}
	@FXML protected void onRemoveOrder_Click(ActionEvent event) {}
	@FXML protected void onEditOrder_Click(ActionEvent event) {}
}
