package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import Data.Order;
import Data.Transport;
import Interface.IOrder;
import Service.OrderFactory;
import Utilities.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrderController implements Initializable{
	private IOrder iOrder = OrderFactory.createInstance();
	@FXML TableColumn<Order, Integer> idCol;
	@FXML TableColumn<Order, Double> amountCol;
	@FXML TableColumn<Order, String> customerCol;
	@FXML TableColumn<Order, String> dealerCol;


	
	@FXML TableView<Order> orderTableList;
	
	@FXML TextField Id;
	@FXML TextField amount;
	@FXML TextField customerId;
	@FXML TextField dealerId;
	int privateOrderId;
	List<Order> data;
	
	@FXML TableView<Order> selectedTransportTableView;
	@FXML TableView<Order> listTransportTableView;
	
	@FXML TableView<Transport>transportOrderTableView;
	
	@FXML TableColumn<Transport, String> transportCol;
	@FXML TableColumn<Transport, String> brandCol;
	@FXML TableColumn<Transport, Double> priceCol;
	@FXML TableColumn<Transport, String> nameCol;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setUpTable();
		loadData();
		
		orderTableList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	
		    	Order order =orderTableList.getSelectionModel().getSelectedItem();
		    	
		    	privateOrderId =order.getId();
		    	this.Id.setText(Integer.toString(order.getId()));
		    	this.amount.setText(Double.toString(order.getAmount()));
		    	this.customerId.setText(order.getCustomerName());
		    	this.dealerId.setText(order.getDealerName());
		    	List<Transport> transport = order.getTransports();
		    	
		    	final ObservableList<Transport> orderTransport = FXCollections.observableArrayList(transport);
		    	transportOrderTableView.setItems(orderTransport);
		    }
		});
	}
	
	private void setUpTable() {
		
		idCol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
		amountCol.setCellValueFactory(new PropertyValueFactory<Order, Double>("amount"));
		customerCol.setCellValueFactory(new PropertyValueFactory<Order, String>("customerName"));	
		dealerCol.setCellValueFactory(new PropertyValueFactory<Order, String>("dealerName"));
		
		transportCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("transportType"));		
		brandCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("brand"));		
		priceCol.setCellValueFactory(new PropertyValueFactory<Transport, Double>("price"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Transport, String>("name"));
	}
	
	private void loadData() {
		// TODO Auto-generated method stub
		String id = this.Id.getText();
		String amount= this.amount.getText();
		String customerId= this.customerId.getText();
		String dealerId = this.dealerId.getText();
		int searchId ;
		if(id.equals("")) {
			searchId=0;
		}
		else {
			searchId=Integer.parseInt(id);
		}
		try {
			data = iOrder.search(searchId, customerId,dealerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		final ObservableList<Order> order = FXCollections.observableArrayList(data);
		
		orderTableList.setItems(order);
		
		
	}
	
	@FXML protected void onCreateOrder_Click(ActionEvent event) {

		if(!Validation.isValidField(amount, customerId, dealerId)) {
			return;
		}
		String id = this.Id.getText();
		String amount= this.amount.getText();
		String customerId= this.customerId.getText();
		String dealerId = this.dealerId.getText();
		Order order = new Order();
		order.setAmount(Double.parseDouble(amount));
		order.setCustomerID(Integer.parseInt(customerId));
		order.setDealerID(Integer.parseInt(dealerId));
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
	
	@FXML protected void onSearchOrder_Click(ActionEvent event) {
		String id = this.Id.getText();
		String amount= this.amount.getText();
		String customerId= this.customerId.getText();
		String dealerId = this.dealerId.getText();
		try {
			data = iOrder.search(id.equals("")?0:Integer.parseInt(id), customerId,dealerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		final ObservableList<Order> order = FXCollections.observableArrayList(data);
		orderTableList.setItems(order);
	}
	@FXML protected void onClearOrder_Click(ActionEvent event) {
		clearTextField();
		loadData();
	}
	@FXML protected void onRemoveOrder_Click(ActionEvent event) {
		Order order = orderTableList.getSelectionModel().getSelectedItem();
		
		try {
			iOrder.deleteOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message(AlertType.ERROR, "Remove Fail","There are some issues with system, please contact administator for support!");
		}
		Message(AlertType.INFORMATION, "Remove Success","Your Order was removed");		
	}
	@FXML protected void onEditOrder_Click(ActionEvent event) {
		
		if(!Validation.isValidField(amount, customerId, dealerId)) {
			return;
		}
		
		String id = this.Id.getText();
		String amount= this.amount.getText();
		String customerId= this.customerId.getText();
		String dealerId = this.dealerId.getText();
		Order order = new Order();
		order.setAmount(Double.parseDouble(amount));
		order.setCustomerID(Integer.parseInt(customerId));
		order.setDealerID(Integer.parseInt(dealerId));
		
		try {
			iOrder.updateOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Message(AlertType.INFORMATION, "Update Success","Your Information was upated");	
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
		this.Id.setText("");
		this.amount.setText("");
		this.customerId.setText("");
		this.dealerId.setText("");
		privateOrderId=-1;
	}
	
}
