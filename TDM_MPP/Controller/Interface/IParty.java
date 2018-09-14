package Interface;

import java.sql.SQLException;
import java.util.List;

import Data.Party;

public interface IParty {
	 void insertParty(Party party) throws SQLException ;
	 void updateParty(Party party)throws SQLException ;
	 void deleteParty(Party party)throws SQLException ;
	 List<Party> search(String id, String name, String email, String phone)throws SQLException ;
	 Party login(String username, String password) throws SQLException;
	List<Party> search(String id, String name, String email, String phone, boolean searchDealerAdmin) ;
	Party getParty(String id) throws SQLException;
}
