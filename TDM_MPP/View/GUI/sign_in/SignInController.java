package GUI.sign_in;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
 
public class SignInController {
    @FXML private Text actiontarget;
    
    @FXML protected void handleSignIn(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }
    
    @FXML protected void handleRegister(ActionEvent event) {
        actiontarget.setText("Sign Up button pressed");
    }

}
