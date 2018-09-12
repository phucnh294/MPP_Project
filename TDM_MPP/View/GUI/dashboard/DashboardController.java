package GUI.dashboard;
 
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import Vehicle.Transport;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class DashboardController implements Initializable {
  
	@FXML
	TableView<Transport> carList;
	
	
	@FXML
	TableColumn<Transport, String> carName;
	@FXML
	TableColumn<Transport,String> carModel;
	@FXML
	TableColumn<Transport, String> carPrice;
	
    private List<Transport> data;
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	setUpTable();
		loadData();
	}

    
    @FXML protected void handleShowDashboard(ActionEvent event) {
        //actiontarget.setText("Sign in button pressed");
    }
    
    @FXML protected void handleAddTrans(ActionEvent event) {
        //actiontarget.setText("Sign Up button pressed");
    }
    
    @FXML protected void handleShowCustomer(ActionEvent event) {
        //actiontarget.setText("Sign in button pressed");
    }
    
    @FXML protected void handleLogout(ActionEvent event) {
        //actiontarget.setText("Sign Up button pressed");
    }
    
    private void loadData() {
//		data = carDao.getAllCars();
//		final ObservableList<String> cars = FXCollections.observableArrayList(data);
//		carList.setItems(cars);
    	
        data = getTransportList();
        final ObservableList<Transport> cars = FXCollections.observableArrayList(data);
		carList.setItems(cars);
        //carList.setItems(list);


	}
    
    private ObservableList<Transport> getTransportList() {
    	 
//    	Transport trans1 = new Transport(1, "ABC", "Mec", 1234);
//    	Transport trans2 = new Transport(2, "ABC2", "Mec", 1234);
//    	Transport trans3 = new Transport(3, "ABC3", "Mec", 1234);
//   
//        ObservableList<Transport> list = FXCollections.observableArrayList(trans1, trans2, trans3);
        return null;
    }
    
    private void setUpTable() {

		carName.setCellValueFactory(new PropertyValueFactory<Transport, String>("name"));
		carModel.setCellValueFactory(new PropertyValueFactory<Transport, String>("brand"));
		carPrice.setCellValueFactory(new PropertyValueFactory<Transport, String>("price"));
		

		// Add Remove button
		TableColumn<Transport, Boolean> removeCol = new TableColumn<>("Remove");

		// define a simple boolean cell value for the action column so that the column
		// will only be shown for non-empty rows.
		removeCol.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Transport, Boolean>, ObservableValue<Boolean>>() {
					@Override
					public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Transport, Boolean> features) {
						return new SimpleBooleanProperty(features.getValue() != null);
					}
				});

		// create a cell value factory with an add button for each row in the table.
		removeCol.setCellFactory(new Callback<TableColumn<Transport, Boolean>, TableCell<Transport, Boolean>>() {
			@Override
			public TableCell<Transport, Boolean> call(TableColumn<Transport, Boolean> booleanTableColumn) {
				return null;// new RemoveCar(carList);
			}
		});

		carList.getColumns().add(removeCol);

	}
}
