package Service;

import java.util.*;

import DAO.TransportDAO;
import Data.Transport;
import Interface.ITransport;

public class TransportFactory {
	public static final ITransport createInstance() {
		return new TransportDAO();
	}
}
