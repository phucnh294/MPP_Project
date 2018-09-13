/**
 * 
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.Conversion;
import Common.SQLConstants;
import Interface.IParty;
import User.Party;
import Utilities.DBUtility;
import Utilities.DatabaseConnection;
//teststse
/**
 * @author ptkie
 *
 */
public class PartyDAO implements SQLConstants, IParty{
	
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
			
			stm.setString(4, party.getPassword());
			stm.setString(5, party.getType());
			stm.setString(6, party.getHobbies());
			stm.setInt(7, party.getMarriageStatus());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}
	}
	
	/**
	 * update a given party
	 * @param party
	 * @throws SQLException
	 */
	public void updateParty(Party party) throws SQLException {
		PreparedStatement stm = null;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_PARTY_SQL);
			stm.setString(1, party.getName());
			stm.setString(2, party.getPhone());
			stm.setString(3, party.getEmail());
			stm.setString(4, party.getPassword());
			stm.setString(5, party.getType());
			stm.setString(6, party.getHobbies());
			stm.setInt(7, party.getMarriageStatus());
			stm.setInt(8, party.getCustomerId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}
		
	}
	
	/**
	 * delete a given party
	 * @param party
	 * @throws SQLException
	 */
	public void deleteParty(Party party) throws SQLException {
		PreparedStatement stm = null;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_PARTY_SQL);			
			stm.setInt(1, party.getCustomerId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}
		
	}
	
	/** 
	 * search parties by given conditions
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	public List<Party> search(String id, String name, String email, String phone) throws SQLException {
		return search(id, name, email, phone, false);
	}
	
	/**
	 * search party with specific condition
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @param searchDealerAdmin
	 * @return
	 * @throws SQLException
	 */
	public List<Party> search(String id, String name, String email, String phone, boolean searchDealerAdmin) {
		List<Party> searchResult = new ArrayList<>();
		PreparedStatement stm = null;
		try {
			StringBuffer sql = new StringBuffer(SEARCH_PARTY_SQL);
			if(id != null && id.trim().length() != 0) {
				
				sql.append(SEARCH_PARTY_ID_CONDITION_SQL.replaceAll("[?]", id));
			}
			if(name != null && name.trim().length() != 0) {
				sql.append(SEARCH_PARTY_NAME_CONDITION_SQL.replaceAll("[?]",name));
			}
			if(email != null && name.trim().length() != 0) {
				sql.append(SEARCH_PARTY_EMAIL_CONDITION_SQL.replaceAll("[?]", email));
			}
			if(phone != null && phone.trim().length() != 0) {
				sql.append(SEARCH_PARTY_PHONE_CONDITION_SQL.replaceAll("[?]", phone));
			}
			if(searchDealerAdmin) {
				sql.append(SEARCH_PARTY_TYPE_CONDITION_SQL);
			}
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(sql.toString());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				searchResult.add(Conversion.toParty(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}		
		return searchResult;
	}
	
	/**
	 * login
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Party login(String username, String password) throws SQLException {

		PreparedStatement stm = null;
		ResultSet rs;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(SIGNIN_SQL);
			stm.setString(1, username);
			stm.setString(2, password);
			rs = stm.executeQuery();
			if (rs.next()) {				
				return Conversion.toParty(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}

		return null;
	}	
	

}
