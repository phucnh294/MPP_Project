package GUI.Customer;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import Interface.IParty;
import Service.PartyFactory;
import User.Party;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerController implements Initializable{
	List<Party> data;
	private IParty iparty = PartyFactory.createInstance();
	@FXML TextField Id;
	@FXML TextField name;
	@FXML TextField phone;
	@FXML TextField email;
	@FXML TableView<Party> partyTableList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub		
		setUpTable();
		loadData();
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
		// TODO Auto-generated method stub
		
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
		}
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
			this.Id.setText("");
			this.name.setText("");
			this.phone.setText("");
			this.email.setText("");
	}
	
	@FXML protected void onEdit_Click(ActionEvent event) {
		Party party = partyTableList.getSelectionModel().getSelectedItem();
		
		party.setName(this.name.getText()); 
		party.setPhone(this.phone.getText());
		party.setEmail(this.email.getText());
		
		try {
			iparty.updateParty(party);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML protected void onRemove_Click(ActionEvent event) {
		Party party = partyTableList.getSelectionModel().getSelectedItem();
		try {
			iparty.deleteParty(party);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
