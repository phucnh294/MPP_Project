package Common;

import java.sql.ResultSet;
import java.sql.SQLException;

import User.Dealer;

public class Conversion implements SQLConstants {

	public static Dealer toDealer(ResultSet rs) {
		if (rs == null) return null;
		
		Dealer dealer = new Dealer();
//		dealer.setAddress(//TODO));
		try {
			dealer.setBirthDate(rs.getDate(BIRTHDATE_PARTY_COLUMN).toLocalDate());
			dealer.setEmail(rs.getString(EMAIL_PARTY_COLUMN));
			dealer.setName(rs.getString(NAME_PARTY_COLUMN));
			dealer.setPassword(rs.getString(PASSWORD_PARTY_COLUMN));
			dealer.setPhone(rs.getString(PHONE_PARTY_COLUMN));
			dealer.setUsername(rs.getString(EMAIL_PARTY_COLUMN));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return dealer;
	}
}
