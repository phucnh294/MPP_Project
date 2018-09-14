package Interface;

import java.sql.SQLException;
import java.util.List;

import Data.Order;

public interface IOrder {
	public void insertOrder(Order order) throws SQLException;
	public void updateOrder(Order ord) throws SQLException ;
	public void deleteOrder(Order ord) throws SQLException;
	public List<Order> search(int id, String customerName, String transportName) throws SQLException;
	//public List<OrderDetail> searchDetail(int id, String customerName, String transportName) throws SQLException;
}
