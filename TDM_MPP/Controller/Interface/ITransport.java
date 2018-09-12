package Interface;

import java.util.ArrayList;

import Vehicle.Transport;
public interface ITransport {
	public Transport getTransport(int id); 
	public ArrayList<Transport> getAllTransport();
	public boolean updateTransport(int id) ;
	public boolean deteleTransport(int id);
}
