package GUI.Customer;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import Interface.IParty;
import Service.PartyFactory;
import User.Party;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


public class CustomerController implements Initializable{
	List<Party> data;
	private IParty iparty = PartyFactory.createInstance();
	@FXML TextField Id;
	@FXML TextField name;
	@FXML TextField phone;
	@FXML TextField email;
	@FXML TableView<Party> partyTableList;
	int privateId;
	@FXML
	TableColumn<Customer, String> nameCol;
	@FXML
	TableColumn<Customer, String> phoneCol;
	@FXML
	TableColumn<Customer, String> emailCol;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub		
		setUpTable();
		loadData();
		partyTableList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	
		    	Party party =partyTableList.getSelectionModel().getSelectedItem();
		    	
		    	privateId =party.getCustomerId();
		    	this.Id.setText(Integer.toString(party.getCustomerId()));
		    	this.name.setText(party.getName());
		    	this.phone.setText(party.getPhone());
		    	this.email.setText(party.getEmail());
		    }
		});
	}

	private void loadData() {
		// TODO Auto-generated method stub
		String id = this.Id.getText();
		String name= this.name.getText();
		String phone= this.phone.getText();
		String email = this.email.getText();
		try {
			data = iparty.search(id,name,email,phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		final ObservableList<Party> parties = FXCollections.observableArrayList(data);
		partyTableList.setItems(parties);
	}

	private void setUpTable() {
		nameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
		phoneCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));	
		
	}
	
	@FXML protected void onCreateCustomer_Click(ActionEvent event) {
		String id = this.Id.getText();
		String name= this.name.getText();
		String phone= this.phone.getText();
		String email = this.email.getText();
		Party party = new Party();
		party.setName(name);
		party.setPhone(phone);
		party.setEmail(email);
		try {
			iparty.insertParty(party);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message(AlertType.ERROR, "Create Fail","There are some issues with system, please contact administator for support!");			
		}
		Message(AlertType.INFORMATION, "Create Success","Your Information was recorded");	
	}
	
	@FXML protected void onSearch_Click(ActionEvent event) throws Exception {
		String id = this.Id.getText();
		String name= this.name.getText();
		String phone= this.phone.getText();
		String email = this.email.getText();
		
		List<Party> data = iparty.search(id,name,email,phone);
		final ObservableList<Party> parties = FXCollections.observableArrayList(data);
		partyTableList.setItems(parties);
	}
	
	@FXML protected void onClear_Click(ActionEvent event) {
		clearTextField();
	}
	
	private void clearTextField() {
		this.Id.setText("");
		this.name.setText("");
		this.phone.setText("");
		this.email.setText("");
		privateId=-1;
	}
	
	@FXML protected void onEdit_Click(ActionEvent event) {
		Party party = partyTableList.getSelectionModel().getSelectedItem();
		party.setCustomerId(privateId);
		party.setName(this.name.getText()); 
		party.setPhone(this.phone.getText());
		party.setEmail(this.email.getText());
		
		try {
			iparty.updateParty(party);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Message(AlertType.INFORMATION, "Update Success","Your Information was upated");		
	}	
	
	private void Message(AlertType type,String tilte, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(tilte);
		alert.setContentText(message);
		alert.show();
		clearTextField();
		loadData();
	}	

	@FXML protected void onRemove_Click(ActionEvent event) {
		Party party = partyTableList.getSelectionModel().getSelectedItem();
		party.setCustomerId(privateId);
		party.setName(this.name.getText()); 
		party.setPhone(this.phone.getText());
		party.setEmail(this.email.getText());
		try {
			iparty.deleteParty(party);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message(AlertType.ERROR, "Remove Fail","There are some issues with system, please contact administator for support!");
		}
		Message(AlertType.INFORMATION, "Remove Success","Your Information was removed");		
	}
	
}
