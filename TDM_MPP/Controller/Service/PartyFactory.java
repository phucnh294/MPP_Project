package Service;

import java.sql.SQLException;
import java.util.List;

import DAO.PartyDAO;
import Data.Party;
import Interface.IParty;


public class PartyFactory extends PartyDAO{
	public static final IParty createInstance() {
		return new PartyDAO();
	}
}
