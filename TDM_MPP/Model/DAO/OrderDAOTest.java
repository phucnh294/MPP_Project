/**
 * 
 */
package DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Order.Order;
import Order.OrderTransport;
import User.Party;
import Vehicle.Transport;

/**
 * @author ptkie
 *
 */
public class OrderDAOTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		OrderDAO ordDAO = new OrderDAO();
		
		Order ord = new Order();
		ord.setId(1);
		ord.setAmount(2000);
		ord.setCustomerID(2);
		ord.setDealerID(2);
		ord.setOrderDate(LocalDate.now());
		List<OrderTransport> transports = new ArrayList<>();
		OrderTransport trans1 = new OrderTransport();
		trans1.setTransportID(1);
		trans1.setPrice(1000);
		OrderTransport trans2 = new OrderTransport();
		trans2.setTransportID(2);
		trans2.setPrice(30000);
		transports.add(trans2);
		transports.add(trans1);		
		
		ordDAO.insertOrder(ord, transports);
		
//		ordDAO.deleteOrder(ord);
		
		
		
		

	}

}
