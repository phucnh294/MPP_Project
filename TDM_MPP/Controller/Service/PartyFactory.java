package Service;

import java.sql.SQLException;
import java.util.List;

import DAO.PartyDAO;
import Interface.IParty;
import User.Party;


public class PartyFactory extends PartyDAO{
	public static final IParty createInstance() {
		return new PartyDAO();
	}
}
