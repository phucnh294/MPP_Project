package View;

import java.net.URL;

import java.util.ResourceBundle;

import GUI.order.Order;
import GUI.Customer.Customer;
import GUI.Transport.AddTransport;
import Vehicle.Transport;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class AppController implements Initializable {

	private static AppController INSTANCE;
	@FXML
	TreeView<String> treeView;

	@FXML
	BorderPane borderPane;

	@FXML
	TitledPane content;

	TreeItem<String> root;
	TreeItem<String> management;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		INSTANCE = this;
		root = new TreeItem<>("Car Dealer System");
		treeView.setRoot(root);
		treeView.setPrefWidth(250);
		treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Node node = event.getPickResult().getIntersectedNode();
				if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
					String name = (String) ((TreeItem) treeView.getSelectionModel().getSelectedItem()).getValue();
					if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
						
						if ("Customer".equals(name)) {
							Customer customer = new Customer(null);
							content.setText(name);
							content.setContent(customer.getTilePane());
						}  else if ("Add a new car".equals(name)) {
							AddTransport addCar = new AddTransport(null);
							content.setText(name);
							content.setContent(addCar.getTilePane());
						} else if ("Order".equals(name)) {
							Order contract = new Order(null);
							content.setText(name);
							content.setContent(contract.getTilePane());
						} else if ("Transport".equals(name)) {
							AddTransport contract = new AddTransport(null);
							content.setText(name);
							content.setContent(contract.getTilePane());
						}
					}
				}
			}
		});
		root.setExpanded(true);
		// Customer
		TreeItem<String> customer = new TreeItem<>("Customer", getImageView("customer.png"));
		root.getChildren().add(customer);
		
		TreeItem<String> car = new TreeItem<>("Transport", getImageView("Car.png"));
//		TreeItem<String> addNewCar = new TreeItem<>("Add a new car", getImageView("add.png"));
//		car.getChildren().add(addNewCar);
//		TreeItem<String> listCar = new TreeItem<>("List cars", getImageView("list.png"));
//		car.getChildren().add(listCar);
		root.getChildren().add(car);

		TreeItem<String> contract = new TreeItem<>("Order", getImageView("contract.png"));
//		TreeItem<String> rentCar = new TreeItem<>("Create Order", getImageView("rentCar.png"));
//		contract.getChildren().add(rentCar);
//		TreeItem<String> returnCar = new TreeItem<>("List Order", getImageView("returnCar.jpeg"));
//		contract.getChildren().add(returnCar);
		root.getChildren().add(contract);

		// User
		management = new TreeItem<>("Management", getImageView("Management.png"));
		root.getChildren().add(management);
		TreeItem<String> createUser = new TreeItem<>("Create User", getImageView("createUser.png"));
		management.getChildren().add(createUser);
		TreeItem<String> listUser = new TreeItem<>("List User", getImageView("listUser.png"));
		management.getChildren().add(listUser);

	}

	public static AppController getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(AppController iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	private ImageView getImageView(String fileName) {
		Image img;
		try {
			img = new Image("/"+fileName);
			ImageView imgView = new ImageView(img);
			imgView.setFitWidth(20);
			imgView.setFitHeight(20);
			return imgView;
		}catch (Exception e) {
		}
//		ImageView imgView = new ImageView(img);
//		imgView.setFitWidth(20);
//		imgView.setFitHeight(20);
		return null;
	}

	@FXML
	private void exitAction(ActionEvent event) {
		Main.getPrimaryStage().close();
	}

	public void disableManagementMenu() {
		root.getChildren().remove(management);
	}

}
