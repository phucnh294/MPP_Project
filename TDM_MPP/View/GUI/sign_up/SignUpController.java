package GUI.sign_up;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
 
public class SignUpController {
    @FXML private Text actiontarget;
    
    
    @FXML protected void handleRegister(ActionEvent event) {
        actiontarget.setText("Sign Up button pressed");
    }

}
