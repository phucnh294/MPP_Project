/**
 * 
 */
package DAO;

import java.sql.SQLException;
import java.time.LocalDate;

import User.Party;

/**
 * @author ptkie
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		PartyDAO partyDAO = new PartyDAO();
		
		Party party = new Party();
		party.setBirthDate(LocalDate.now());
		party.setEmail("kien.ptx@gmail.com");
		party.setHobbies("play sports and watch movies");
		party.setMarriageStatus(1);
		party.setName("Trung Kien Pham");
		party.setPassword("123456");
		party.setPhone("6122242661");
		party.setType("CUSTOMER");
		party.setUsername(party.getEmail());
		partyDAO.insertParty(party);

	}

}
