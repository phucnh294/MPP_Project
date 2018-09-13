package Interface;

import java.sql.SQLException;
import java.util.List;

import User.Party;

public interface IParty {
	public void insertParty(Party party) throws SQLException ;
	public void updateParty(Party party)throws SQLException ;
	public void deleteParty(Party party)throws SQLException ;
	public List<Party> search(String id, String name, String email, String phone)throws SQLException ;
	public Party login(String username, String password) throws SQLException;
}
