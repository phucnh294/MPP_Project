package Service;

import java.util.*;

import Interface.ITransport;
import Vehicle.Transport;

public class TransportService implements ITransport {
	public Transport getTransport(int id) {		
		return new Transport();
	}
	
	public ArrayList<Transport> getAllTransport(){
		return new ArrayList<Transport>();
	}
	
	public boolean updateTransport(int id) {
		return true;
	}
	
	public boolean deteleTransport(int id) {
		return true;
	}
}
