package Common;

import java.sql.ResultSet;
import java.sql.SQLException;

import User.Party;

public class Conversion implements SQLConstants {

	public static Party toParty(ResultSet rs) {
		if (rs == null) return null;
		
		Party party = new Party();
		try {
			party.setCustomerId(rs.getInt(ID_PARTY_COLUMN));
			party.setName(rs.getString(NAME_PARTY_COLUMN));
			party.setPhone(rs.getString(PHONE_PARTY_COLUMN));
			party.setEmail(rs.getString(EMAIL_PARTY_COLUMN));
			party.setBirthDate(rs.getDate(BIRTHDATE_PARTY_COLUMN).toLocalDate());
			party.setPassword(rs.getString(PASSWORD_PARTY_COLUMN));
			party.setType(rs.getString(TYPE_PARTY_COLUMN));
			party.setHobbies(rs.getString(HOBBIES_PARTY_COLUMN));
			party.setMarriageStatus(rs.getInt(MARRIAGE_STATUS_PARTY_COLUMN));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return party;
	}
}
