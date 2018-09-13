/**
 * 
 */
package DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import User.Party;

/**
 * @author ptkie
 *
 */
public class PartyDAOTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		PartyDAO partyDAO = new PartyDAO();
		
		Party party = new Party();
//		party.setBirthDate(LocalDate.now());
//		party.setEmail("kien.ptx@gmail.com");
//		party.setHobbies("play sports and watch movies");
//		party.setMarriageStatus(1);
//		party.setName("Trung Kien Pham");
//		party.setPassword("123456");
//		party.setPhone("6122242661");
//		party.setType("CUSTOMER");
//		party.setUsername(party.getEmail());
//		partyDAO.insertParty(party);
//		
//		party.setBirthDate(LocalDate.now());
//		party.setEmail("phuc.nguyen@gmail.com");
//		party.setHobbies("play sports and watch movies");
//		party.setMarriageStatus(0);
//		party.setName("Phuc Nguyen");
//		party.setPassword("123456");
//		party.setPhone("6122242661");
//		party.setType("DEALER");
//		party.setUsername(party.getEmail());
//		partyDAO.insertParty(party);
//		
//		party.setBirthDate(LocalDate.now());
//		party.setEmail("muhabar.nguyen@gmail.com");
//		party.setHobbies("play sports and watch movies");
//		party.setMarriageStatus(0);
//		party.setName("Muhabar");
//		party.setPassword("123456");
//		party.setPhone("6122242661");
//		party.setType("DEALER");
//		party.setUsername(party.getEmail());
//		partyDAO.insertParty(party);
//		
//		party.setBirthDate(LocalDate.now());
//		party.setEmail("obina.kalu@gmail.com");
//		party.setHobbies("play sports and watch movies and travelling");
//		party.setMarriageStatus(0);
//		party.setName("Kalu");
//		party.setPassword("123456");
//		party.setPhone("6122242661");
//		party.setType("DEALER");
//		party.setUsername(party.getEmail());
//		party.setCustomerId(1);
//		partyDAO.insertParty(party);
		
//		partyDAO.deleteParty(party);
		
//		List<Party> parties = partyDAO.search(null, null, "gmail", "12");
//		System.out.println(parties);
		
		Party partydd = partyDAO.login("kien.ptx@gmail.com", "123456");
		System.out.println(partydd);
		

	}

}
