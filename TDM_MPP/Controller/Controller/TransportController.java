package Controller;

import java.util.*;

import Vehicle.Transport;

public class TransportController  {
	Transport transport;
	ArrayList<Transport> transports;
	
	public Transport getTransport(int id) {
		return transport;		
	}
	
	public ArrayList<Transport> getAllTransport() {
		return transports;		
	}
	
	public boolean updateTransport(int id) {
		return true;
	}
	
	public boolean deleteTransport(int id) {//just update status to delete no need do the hard delete
		return true;
	}

}
