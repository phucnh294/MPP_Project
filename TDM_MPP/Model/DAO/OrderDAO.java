/**
 * 
 */
package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.Conversion;
import Common.SQLConstants;
import User.Party;
import Utilities.DBUtility;
import Utilities.DatabaseConnection;

/**
 * @author ptkie
 *
 */
public class OrderDAO implements SQLConstants{
	
	/**
	 * insert a new party
	 * @param party
	 * @throws SQLException
	 */
//	public void insertOrder(Order) throws SQLException {
//		PreparedStatement stm = null;
//		try {
//			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_PARTY_SQL);
//			stm.setString(1, party.getName());
//			stm.setString(2, party.getPhone());
//			stm.setString(3, party.getEmail());
//			stm.setDate(4, Date.valueOf(party.getBirthDate()));
//			stm.setString(5, party.getPassword());
//			stm.setString(6, party.getType());
//			stm.setString(7, party.getHobbies());
//			stm.setInt(8, party.getMarriageStatus());
//			stm.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			stm.close();
//		}
//	}
	
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
			stm.setDate(4, Date.valueOf(party.getBirthDate()));
			stm.setString(5, party.getPassword());
			stm.setString(6, party.getType());
			stm.setString(7, party.getHobbies());
			stm.setInt(8, party.getMarriageStatus());
			stm.setInt(9, party.getCustomerId());
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
		List<Party> searchResult = new ArrayList<>();
		PreparedStatement stm = null;
		try {
			StringBuffer sql = new StringBuffer(SEARCH_PARTY_SQL);
			if(id != null) {
				
				sql.append(SEARCH_PARTY_ID_CONDITION_SQL.replaceAll("?", id));
			}
			if(name != null) {
				sql.append(SEARCH_PARTY_NAME_CONDITION_SQL.replaceAll("?", DBUtility.toDBString(name)));
			}
			if(email != null) {
				sql.append(SEARCH_PARTY_EMAIL_CONDITION_SQL.replaceAll("?", DBUtility.toDBString(email)));
			}
			if(phone != null) {
				sql.append(SEARCH_PARTY_PHONE_CONDITION_SQL.replaceAll("?", DBUtility.toDBString(phone)));
			}
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(sql.toString());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				searchResult.add(Conversion.toParty(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}
		
		return searchResult;
	}
	

}
