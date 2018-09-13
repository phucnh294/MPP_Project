package Service;

import java.util.*;

import DAO.TransportDAO;
import Interface.ITransport;
import Vehicle.Transport;

public class TransportFactory {
	public static final ITransport createInstance() {
		return new TransportDAO();
	}
}
