package Common;

import java.sql.ResultSet;
import java.sql.SQLException;

import User.Dealer;

public class Conversion implements SQLConstants {

	public static Dealer toDealer(ResultSet rs) {
		Dealer dealer = new Dealer();
//		dealer.setAddress(//TODO));
		try {
			dealer.setBirthDate(rs.getDate(BIRTHDATE_COLUMN).toLocalDate());
			dealer.setEmail(rs.getString(EMAIL_COLUMN));
			dealer.setName(rs.getString(NAME_COLUMN));
			dealer.setPassword(rs.getString(PASSWORD_COLUMN));
			dealer.setPhone(rs.getInt(PHONE_COLUMN));
			dealer.setUsername(rs.getString(EMAIL_COLUMN));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return dealer;
	}
}
