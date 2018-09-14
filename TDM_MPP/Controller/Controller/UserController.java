package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import Data.Party;
import GUI.Customer.CustomerView;
import Interface.IParty;
import Service.PartyFactory;
import Utilities.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserController implements Initializable {
	
	List<Party> data;
	private IParty iparty = PartyFactory.createInstance();
	@FXML TextField Id;
	@FXML TextField name;
	@FXML TextField phone;
	@FXML TextField email;
	@FXML PasswordField password;
	@FXML PasswordField verifyPwd;
	@FXML TableView<Party> userTableList;
	@FXML RadioButton dealerRadio;
	@FXML RadioButton adminRadio;
	int privateId;
	@FXML
	TableColumn<CustomerView, String> nameCol;
	@FXML
	TableColumn<CustomerView, String> typeCol;
	@FXML
	TableColumn<CustomerView, String> emailCol;
	private final String DEALER_TYPE = "DEALER";
	private final String ADMIN_TYPE = "ADMIN";

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
		setUpTable();
		loadData();
		userTableList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	
		    	Party party = userTableList.getSelectionModel().getSelectedItem();
		    	name.setText(party.getName());
//		    	password.setText(party.getPassword());
		    	email.setText(party.getEmail());
		    	if(DEALER_TYPE.equals(party.getType())) {
		    		dealerRadio.setSelected(true);
		    	} else {
		    		adminRadio.setSelected(true);
		    	}
		    }
		});
	}

	private void loadData() {
		
		try {
			data = iparty.search(null, name.getText(), email.getText(), null, true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		final ObservableList<Party> parties = FXCollections.observableArrayList(data);
		userTableList.setItems(parties);
	}

	private void setUpTable() {
		nameCol.setCellValueFactory(new PropertyValueFactory<CustomerView, String>("name"));
		typeCol.setCellValueFactory(new PropertyValueFactory<CustomerView, String>("type"));
		emailCol.setCellValueFactory(new PropertyValueFactory<CustomerView, String>("email"));	
		
	}
	
	@FXML protected void onCreateCustomer_Click(ActionEvent event) {
		if(!Validation.isValidField(email, name, password, verifyPwd)) {
			return;
		}
		
		if(!Validation.isValidEmail(email)) {
			return;
		}
		
		if(!Validation.verifyPassword(password, verifyPwd)) {
			return;
		}
		
		Party party = new Party();
		party.setName(name.getText());
		party.setEmail(email.getText());
		party.setPassword(password.getText());
		if(dealerRadio.isSelected()) {
			party.setType(DEALER_TYPE);
		} else {
			party.setType(ADMIN_TYPE);
		}
		try {
			iparty.insertParty(party);
			Message(AlertType.INFORMATION, "Create Success","New user is created successfully.");	
			
		} catch (SQLException e) {
			e.printStackTrace();
			Message(AlertType.ERROR, "Create Fail","There are some issues with system, please contact administator for support!");			
		}
		
	}
	
	@FXML protected void onSearch_Click(ActionEvent event) throws Exception {
		loadData();
		clearTextField();
	}
	
	@FXML protected void onClear_Click(ActionEvent event) {
		clearTextField();
	}
	
	private void clearTextField() {
		name.setText("");
		password.setText("");
		email.setText("");
		verifyPwd.setText("");
	}
	
	@FXML protected void onEdit_Click(ActionEvent event) {
		if(!Validation.isValidField(name, email)) {
			return;
		}
		
		if(!Validation.isValidEmail(email)) {
			return;
		}
		
		if(!Validation.verifyPassword(password, verifyPwd)) {
			return;
		}
		Party party = userTableList.getSelectionModel().getSelectedItem();
		party.setName(name.getText()); 
		party.setEmail(email.getText());
		if(password.getText() != null && password.getText().length() > 0 && Validation.verifyPassword(password, verifyPwd)){
			party.setPassword(password.getText());
		}	
		if(dealerRadio.isSelected()) {
			party.setType(DEALER_TYPE);
		} else {
			party.setType(ADMIN_TYPE);
		}
		
		try {
			iparty.updateParty(party);
			Message(AlertType.INFORMATION, "User","The information is updated successfully");		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}	
	
	public void Message(AlertType type,String tilte, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(tilte);
		alert.setContentText(message);
		alert.show();
		clearTextField();
		loadData();
	}	

	@FXML protected void onRemove_Click(ActionEvent event) {
		Party party = userTableList.getSelectionModel().getSelectedItem();
		if (party == null) {
			showMessage(AlertType.WARNING, "User", "Please choose an item");
			return;
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("User");
			alert.setContentText("Are you sure you want to remove this item?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() != ButtonType.OK){
			    return;
			} 
		}
		
		try {
			iparty.deleteParty(party);
			Message(AlertType.INFORMATION, "Remove Success","Your Information was removed");	
		} catch (SQLException e) {
			
			e.printStackTrace();
			Message(AlertType.ERROR, "Remove Fail","There are some issues with system, please contact administator for support!");
		}
			
	}
	
	@FXML
	protected void onClearTransport_Click(ActionEvent event) {
		name.setText("");
		email.setText("");
		password.setText("");
		dealerRadio.setSelected(false);
		adminRadio.setSelected(false);
	}
	
	private void showMessage(AlertType type, String tilte, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(tilte);
		alert.setContentText(message);
		alert.show();
		clearTextField();
		loadData();
	}
}
