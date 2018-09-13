package GUI.Transport;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import Interface.ITransport;
import Service.TransportFactory;
import Utilities.Validation;
import Vehicle.Transport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddTransportController implements Initializable {
	List<Transport> data;
	private ITransport itransport = TransportFactory.createInstance();
	@FXML
	Label Id;
	@FXML
	TextField name;
	@FXML
	TextField brand;
	@FXML
	TextField model;
	@FXML
	TextField description;
	@FXML
	TextField price;
	@FXML
	TableColumn<Transport, String> nameCol;
	@FXML
	TableColumn<Transport, String> brandCol;
	@FXML
	TableColumn<Transport, Double> priceCol;
	@FXML
	TableColumn<Transport, String> modelCol;

	@FXML
	TableView<Transport> CusTableList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setUpTable();
		loadData();
		CusTableList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {

				Transport tran = CusTableList.getSelectionModel().getSelectedItem();
				Id.setText(String.valueOf(tran.getId()));
				name.setText(tran.getName());
				brand.setText(tran.getBrand());
				model.setText(tran.getModel());
				description.setText(tran.getDescription());
				price.setText(String.valueOf(tran.getPrice()));

			}
		});
	}

	private void loadData() {

		try {
			data = itransport.searchTransport(name.getText(), brand.getText(), model.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		final ObservableList<Transport> transports = FXCollections.observableArrayList(data);
		CusTableList.setItems(transports);
	}

	private void setUpTable() {
		nameCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("name"));
		brandCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("brand"));
		priceCol.setCellValueFactory(new PropertyValueFactory<Transport, Double>("price"));
		modelCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("model"));

	}

	@FXML
	protected void onCreateTransport_Click(ActionEvent event) {
		if(!Validation.isValidField(name, brand, model, description, price)) {
			//showMessage(AlertType.ERROR, "Error", "All Fields is required");
			return;
		}
		
		Transport tran = new Transport();
		tran.setName(name.getText());
		tran.setBrand(brand.getText());
		tran.setCreatedDate(LocalDate.now());
		tran.setDescription(description.getText());
		tran.setFuelType(null);
		tran.setManufactor(null);
		tran.setMileage(10000);
		tran.setModel(model.getText());
		tran.setNumberOfEngine(1);
		if (price.getText() != null && price.getText().length() > 0) {
			try {
				tran.setPrice(Double.parseDouble(price.getText().trim()));
			} catch (Exception e) {
				// skip
			}
		}
		try {
			itransport.insertTransport(tran);
			showMessage(AlertType.INFORMATION, "Transport", "Transport is created Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	protected void SearchTransport_Click(ActionEvent event) {
		loadData();
	}

	@FXML
	protected void onClearTransport_Click(ActionEvent event) {
		name.setText("");
		brand.setText("");
		price.setText("");
		brand.setText("");
		model.setText("");
		description.setText("");
	}

	@FXML
	protected void onRemoveTransport_Click(ActionEvent event) {
		Transport tran = CusTableList.getSelectionModel().getSelectedItem();
		if (tran == null) {
			showMessage(AlertType.WARNING, "Transport", "Please choose an item");
			return;
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Transport");
			alert.setContentText("Are you sure you want to remove this item?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() != ButtonType.OK){
			    return;
			} 
		}
		try {
			itransport.deleteTransport(tran);
		} catch (Exception e) {
			e.printStackTrace();
			showMessage(AlertType.ERROR, "Transport",
					"There are some issues with system, please contact administator for support!");
		}
		showMessage(AlertType.INFORMATION, "Transport", "The Item is deleted successfully");
	}

	@FXML
	protected void onEditTransport_Click(ActionEvent event) {
		if(!Validation.isValidField(name, brand, model, description, price)) {
			//showMessage(AlertType.ERROR, "Error", "All Fields is required");
			return;
		}
		Transport tran = CusTableList.getSelectionModel().getSelectedItem();
		tran.setName(name.getText());
		tran.setBrand(brand.getText());
		tran.setModel(model.getText());
		tran.setDescription(description.getText());
		if (price.getText() != null && price.getText().length() > 0) {
			try {
				tran.setPrice(Double.parseDouble(price.getText().trim()));
			} catch (Exception e) {
				// skip
			}
		}

		try {
			itransport.updateTransport(tran);
			showMessage(AlertType.INFORMATION, "Transport", "The Information is updated successfully.");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void showMessage(AlertType type, String tilte, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(tilte);
		alert.setContentText(message);
		alert.show();
		clearTextField();
		loadData();
	}

	private void clearTextField() {
		name.setText("");
		brand.setText("");
		price.setText("");
		brand.setText("");
		model.setText("");
		description.setText("");
	}

}
