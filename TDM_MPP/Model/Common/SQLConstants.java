/**
 * 
 */
package Common;

/**
 * @author ptkie
 *
 */
public interface SQLConstants {

	String SIGNIN_SQL = "Select * From Dealer Where email = ? and password = ?";
	
	String ID_COLUMN = "ID";
	String NAME_COLUMN = "NAME";
	String PHONE_COLUMN = "PHONE";
	String EMAIL_COLUMN = "EMAIL";
	String BIRTHDATE_COLUMN = "BIRTHDATE";
	String PASSWORD_COLUMN = "PASSWORD";
	String TYPE_COLUMN = "TYPE";
	String HOBBIES_COLUMN = "HOBBIES";
	String MARRIAGE_STATUS_COLUMN = "MARRIAGE_STATUS";
	 
}
