package Interface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Vehicle.Transport;
public interface ITransport {
	void insertTransport(Transport transport) throws SQLException; 
	void updateTransport(Transport transport) throws SQLException ;
	List<Transport> search(double fromPrice, double toPrice, String manufacturer, int seatCapacity)
			throws SQLException ;
	
	List<Transport> searchTransport(String name, String brand, String model);
	void deleteTransport(Transport transport);
}
