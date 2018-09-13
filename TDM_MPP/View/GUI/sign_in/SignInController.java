package GUI.sign_in;
 
import java.io.IOException;
import java.sql.SQLException;

import GUI.dashboard.Dashboard;
import Interface.IParty;
import Service.PartyFactory;
import User.Party;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;


 
public class SignInController {
	private IParty iparty = PartyFactory.createInstance();
	Party party ;
    @FXML private Text actiontarget;
    @FXML TextField passwordField;
    @FXML TextField usernameField;
    @FXML protected void handleSignIn(ActionEvent event) {
    	
        String username =usernameField.getText();
        String password=  passwordField.getText();
        
//        try {
//        	party= iparty.login(username,password);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();			
//		}
        if(party !=null ||(username.equals("admin") && password.equals("admin"))) {
        	Stage stage =Main.getPrimaryStage();   
        	Main.getLoginStage().close();
			Main.getPrimaryStage().show();
        }else {
        	Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unable to login. Please check emaild and password.");
			alert.show();
        }
    }
    
	@FXML protected void handleRegister(ActionEvent event) {
        actiontarget.setText("Sign Up button pressed");
    }

}
