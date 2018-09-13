package Interface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Vehicle.Transport;
public interface ITransport {
	public void insertTransport(Transport transport) throws SQLException; 
	public void updateTransport(Transport transport) throws SQLException ;
	public List<Transport> search(double fromPrice, double toPrice, String manufacturer, int seatCapacity)
			throws SQLException ;
}
