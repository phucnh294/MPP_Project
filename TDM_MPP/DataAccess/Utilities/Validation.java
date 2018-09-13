package Utilities;

import java.util.regex.Pattern;

import javafx.scene.control.TextField;

public class Validation {

	public static boolean isValidField(TextField... fields) {
		boolean isValid = true;
		for (TextField field : fields) {
			field.getStyleClass().remove("customInput");
			if (getString(field).isEmpty()) {
				field.getStyleClass().add("customInput");
				isValid = false;
			}
		}
		return isValid;
	}

	public static String getString(TextField field) {
		return field.getText().trim();
	}

	public static boolean isValidEmail(TextField textField) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		String email = getString(textField);
		textField.getStyleClass().remove("customInput");
		if (email.isEmpty()) {
			textField.getStyleClass().add("customInput");
			return false;
		}
		if(!pat.matcher(email).matches()) {
			textField.getStyleClass().add("customInput");
			return false;
		}
		return true;
	}
}
