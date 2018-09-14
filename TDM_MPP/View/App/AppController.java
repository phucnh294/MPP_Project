package App;

import java.net.URL;

import java.util.ResourceBundle;

import Data.Transport;
import GUI.order.CreateOrderView;
import GUI.order.OrderView;

import GUI.Customer.CustomerView;
import GUI.Transport.TransportView;
import GUI.User.UserView;
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
							CustomerView customer = new CustomerView(null);
							content.setText(name);
							content.setContent(customer.getTilePane());
						}  else if ("Add a new car".equals(name)) {
							TransportView addCar = new TransportView(null);
							content.setText(name);
							content.setContent(addCar.getTilePane());
						} else if ("Order".equals(name)) {
							OrderView contract = new OrderView(null);
							content.setText(name);
							content.setContent(contract.getTilePane());
						} else if ("Transport".equals(name)) {
							TransportView contract = new TransportView(null);
							content.setText(name);
							content.setContent(contract.getTilePane());
						}else if ("User".equals(name)) {
							UserView userView = new UserView(null);
							content.setText(name);
							content.setContent(userView.getTilePane());
						}else if ("Create Order".equals(name)) {
							CreateOrderView createOrder = new CreateOrderView(null);
							content.setText(name);
							content.setContent(createOrder.getTilePane());
						}
					}
				}
			}
		});
		root.setExpanded(true);
		// Customer
		TreeItem<String> customer = new TreeItem<>("Customer");
		root.getChildren().add(customer);
		
		TreeItem<String> trasnport = new TreeItem<>("Transport");
		root.getChildren().add(trasnport);

		TreeItem<String> contract = new TreeItem<>("Order");
		TreeItem<String> rentCar = new TreeItem<>("Create Order");
		contract.getChildren().add(rentCar);
		root.getChildren().add(contract);

		// User
		management = new TreeItem<>("Management");
		root.getChildren().add(management);
		TreeItem<String> createUser = new TreeItem<>("User");
		management.getChildren().add(createUser);

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
