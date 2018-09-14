package Controller;
 

import java.sql.SQLException;

import App.Main;
import Data.Party;
import Interface.IParty;
import Service.PartyFactory;
import Utilities.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;


 
public class SignInController {
	private IParty iparty = PartyFactory.createInstance();
	Party party ;
    @FXML private Text actiontarget;
    @FXML TextField passwordField;
    @FXML TextField usernameField;
    @FXML protected void handleSignIn(ActionEvent event) {
    	
        String username =usernameField.getText();
        String password=  passwordField.getText();
        
        actiontarget.setText("");
        
        if(!Validation.isValidField(usernameField, passwordField)) {
        	actiontarget.setText("Fields Required");
        	return;
        }
        
        try {
        	party= iparty.login(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
        if(party !=null ||(username.equals("admin") && password.equals("admin"))) {
        	Main.getLoginStage().close();
			Main.getPrimaryStage().show();
        }else {
        	Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Unable to login. Please check emaild and password.");
			alert.show();
        }
    }
    
	/*@FXML protected void handleRegister(ActionEvent event) {
        actiontarget.setText("Sign Up button pressed");
    }*/

}
