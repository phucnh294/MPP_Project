package Interface;

import java.sql.SQLException;
import java.util.List;

import Order.Order;
import Order.OrderDetail;
import Order.OrderTransport;

public interface IOrder {
	public void insertOrder(Order order, List<OrderTransport> orderTransports) throws SQLException;
	public void updateOrder(Order ord) throws SQLException ;
	public void deleteOrder(Order ord) throws SQLException;
	public List<Order> search(int id, String customerName, String transportName) throws SQLException;
	//public List<OrderDetail> searchDetail(int id, String customerName, String transportName) throws SQLException;
}
