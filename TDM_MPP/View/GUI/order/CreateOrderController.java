package GUI.order;

import java.io.Serializable;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Interface.IOrder;
import Interface.ITransport;
import Order.Order;
import Service.OrderFactory;
import Service.TransportFactory;
import Utilities.Validation;
import Vehicle.Transport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CreateOrderController implements Initializable{
	@FXML Button cancelBtn;
	private IOrder iOrder = OrderFactory.createInstance();
	@FXML  TableView<Transport> listTransportTableView;
	@FXML  TableView<Transport> selectedTransportTableView;
	
	
	@FXML TableColumn<Transport, String> transTypeCol;
	@FXML TableColumn<Transport, String> transModelCol;
	@FXML TableColumn<Transport, Double> transPriceCol;
	@FXML TableColumn<Transport, String> transBrandCol;
	
	@FXML TableColumn<Transport, String> selectTransCol;
	@FXML TableColumn<Transport, String> selectModelCol;
	@FXML TableColumn<Transport, Double> selectPriceCol;
	@FXML TableColumn<Transport, String> selectBrandCol;

	
	@FXML TextField customerId;
	@FXML TextField dealerId;
	List<Transport> data;
	List<Transport> selectedData= new ArrayList<Transport>();
	private ITransport itransport = TransportFactory.createInstance();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setUpTable();
		loadData();
	}
	
	private void setUpTable() {
		transTypeCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("transportType"));
		transModelCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("model"));
		transPriceCol.setCellValueFactory(new PropertyValueFactory<Transport, Double>("price"));
		transBrandCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("brand"));
		
		selectTransCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("transportType"));
		selectModelCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("model"));
		selectPriceCol.setCellValueFactory(new PropertyValueFactory<Transport, Double>("price"));
		selectBrandCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("brand"));

	}
	
	private void loadData() {

		try {
			data = itransport.searchTransport("", "", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		final ObservableList<Transport> transports = FXCollections.observableArrayList(data);
		listTransportTableView.setItems(transports);
		
	}
	
	@FXML protected void onSeclecBtn_Clicked(ActionEvent event) {
		
		Transport transport = listTransportTableView.getSelectionModel().getSelectedItem();
		if(transport!=null) {
			selectedData.add(transport);
			 ObservableList<Transport> selecTransports = FXCollections.observableArrayList(selectedData);
				selectedTransportTableView.setItems(selecTransports);
				selectedTransportTableView.refresh();
		}	
		
	}
	
	@FXML protected void onRemoveSelect_Click(ActionEvent event) {
		
		Transport transport = selectedTransportTableView.getSelectionModel().getSelectedItem();
		
		if(transport!=null) {
			selectedData.remove(transport);
			ObservableList<Transport> selecTransports = FXCollections.observableArrayList(selectedData);
			selectedTransportTableView.setItems(selecTransports);
			selectedTransportTableView.refresh();
		}	
		 
	}
	
	@FXML protected void onCreated_Clicked(ActionEvent event) {
		if(!Validation.isValidField(customerId, dealerId)) {
			return;
		}
		double total;
		Order order = new Order();
		for(Transport trans: selectedData) {
			total+= trans.getPrice();
		}
		order.setCustomerID(Integer.parseInt(this.customerId.getText()));
		order.setDealerID(Integer.parseInt(this.dealerId.getText()));
		order.setAmount(total);
		order.setOrderDate(LocalDate.now());
		try {
			iOrder.insertOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message(AlertType.ERROR, "Create Fail","There are some issues with system, please contact administator for support!");			
		}
		Message(AlertType.INFORMATION, "Create Success","Your Order was recorded");	
	}
	@FXML protected void onCancel_Clicked(ActionEvent event) {
		
	}
	public void Message(AlertType type,String tilte, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(tilte);
		alert.setContentText(message);
		alert.show();
		clearTextField();
		loadData();
	}	
	
	private void clearTextField() {
		
		this.customerId.setText("");
		this.dealerId.setText("");
		
		selectedData= new ArrayList<Transport>();
		ObservableList<Transport> selecTransports = FXCollections.observableArrayList(selectedData);
		selectedTransportTableView.setItems(selecTransports);
		selectedTransportTableView.refresh();
	}
}
