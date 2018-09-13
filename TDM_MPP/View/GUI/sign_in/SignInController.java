package GUI.sign_in;
 
import java.io.IOException;

import GUI.dashboard.Dashboard;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


 
public class SignInController {
    @FXML private Text actiontarget;
    @FXML TextField passwordField;
    @FXML TextField usernameField;
    @FXML protected void handleSignIn(ActionEvent event) {
    	
        String username =usernameField.getText();
        String password=  passwordField.getText();
        if(username.equals("admin") && password.equals("admin")) {
        	Stage stage =Main.getPrimaryStage();   
        	Main.getLoginStage().close();
			Main.getPrimaryStage().show();
        }
    }
    
	@FXML protected void handleRegister(ActionEvent event) {
        actiontarget.setText("Sign Up button pressed");
    }

}
