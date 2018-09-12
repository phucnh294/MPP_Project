/**
 * 
 */
package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Common.SQLConstants;
import User.Party;
import Utilities.DatabaseConnection;

/**
 * @author ptkie
 *
 */
public class PartyDAO implements SQLConstants{
	
	/**
	 * insert a new party
	 * @param party
	 * @throws SQLException
	 */
	public void insertParty(Party party) throws SQLException {
		PreparedStatement stm = null;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_PARTY_SQL);
			stm.setString(1, party.getName());
			stm.setString(2, party.getPhone());
			stm.setString(3, party.getEmail());
			stm.setDate(4, Date.valueOf(party.getBirthDate()));
			stm.setString(5, party.getPassword());
			stm.setString(6, party.getType());
			stm.setString(7, party.getHobbies());
			stm.setInt(8, party.getMarriageStatus());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}
	}
	
	public void updateParty(Party party) {
		
	}
	

}
