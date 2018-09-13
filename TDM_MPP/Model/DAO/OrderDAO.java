/**
 * 
 */
package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Common.Conversion;
import Common.SQLConstants;
import Interface.IOrder;
import Order.Order;
import Order.OrderTransport;
import Utilities.DBUtility;
import Utilities.DatabaseConnection;
import Vehicle.Transport;

/**
 * @author ptkie
 *
 */
public class OrderDAO implements SQLConstants,IOrder {

	/**
	 * insert a new party
	 * 
	 * @param party
	 * @throws SQLException
	 */
	public void insertOrder(Order order) throws SQLException {
		PreparedStatement orderStm = null;
		PreparedStatement orderTransportsStm = null;
		boolean currentAutoCommit = DatabaseConnection.getInstance().getConnection().getAutoCommit();
		try {

			DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
			orderStm = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_ORDER_SQL, Statement.RETURN_GENERATED_KEYS);
			orderStm.setDouble(1, order.getAmount());
			orderStm.setDate(2, Date.valueOf(order.getOrderDate()));
			orderStm.setInt(3, order.getCustomerID());
			orderStm.setInt(4, order.getDealerID());
			orderStm.execute();
			ResultSet rs = orderStm.getGeneratedKeys();
			int orderId = -1;
			if(rs.next()) {
				orderId = rs.getInt(1);
				
			}
			orderTransportsStm = DatabaseConnection.getInstance().getConnection()
					.prepareStatement(INSERT_ORDER_TRANSPORT_SQL);
			for (Transport ot : order.getTransports()) {
				orderTransportsStm.setInt(1, orderId);
				orderTransportsStm.setInt(2, ot.getId());
				orderTransportsStm.setDouble(3, ot.getPrice());
				orderTransportsStm.addBatch();
			}
			orderTransportsStm.executeBatch();
			DatabaseConnection.getInstance().getConnection().commit();

		} catch (SQLException e) {
			DatabaseConnection.getInstance().getConnection().rollback();
			e.printStackTrace();
		} finally {
			DatabaseConnection.getInstance().getConnection().setAutoCommit(currentAutoCommit);
			orderStm.close();
			orderTransportsStm.close();
		}
	}

	/**
	 * update a given transport
	 * 
	 * @param party
	 * @throws SQLException
	 */
	public void updateOrder(Order ord) throws SQLException {
		PreparedStatement stm = null;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_ORDER_SQL);
			stm.setDouble(1, ord.getAmount());
			stm.setDate(2, Date.valueOf(ord.getOrderDate()));
			stm.setInt(3, ord.getCustomerID());
			stm.setInt(4, ord.getDealerID());
			stm.setInt(5, ord.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}

	}

	/**
	 * delete a given party
	 * 
	 * @param party
	 * @throws SQLException
	 */
	public void deleteOrder(Order ord) throws SQLException {
		PreparedStatement stm = null;
		PreparedStatement stm2 = null;
		boolean currentAutoCommit = DatabaseConnection.getInstance().getConnection().getAutoCommit();
		try {
			DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_ORDER_SQL);
			stm.setInt(1, ord.getId());
			stm.execute();
			stm2 = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_ORDER_TRANSPORT_SQL);
			stm2.setInt(1, ord.getId());
			stm2.execute();
			DatabaseConnection.getInstance().getConnection().commit();
		} catch (SQLException e) {
			DatabaseConnection.getInstance().getConnection().rollback();
			e.printStackTrace();
		} finally {
			DatabaseConnection.getInstance().getConnection().setAutoCommit(currentAutoCommit);
			stm.close();
			stm2.close();
		}

	}

	/**
	 * search parties by given conditions
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	public List<Order> search(int id, String customerName, String transportName) throws SQLException {
		List<Order> searchResult = new ArrayList<>();
		PreparedStatement stm = null;
		try {
			StringBuffer sql = new StringBuffer(SEARCH_ORDER_SQL);
			if (id > 0) {

				sql.append(SEARCH_ORDER_ID_CONDITION_SQL.replaceAll("[?]", String.valueOf(id)));
			}
			if (customerName != null && customerName.trim().length() != 0) {
				sql.append(SEARCH_ORDER_PARTY_NAME_CONDITION_SQL.replaceAll("[?]", DBUtility.toDBString(customerName)));
			}
			if (transportName != null && transportName.trim().length() != 0) {
				sql.append(
						SEARCH_ORDER_TRANSPORT_NAME_CONDITION_SQL.replaceAll("[?]", DBUtility.toDBString(transportName)));
			}
			sql.append(SEARCH_ORDER_SORT_SQL);

			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(sql.toString());

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				searchResult.add(Conversion.toOrderTransports(rs, searchResult));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}

		return searchResult;
	}

//	public List<OrderDetail> searchDetail(int id, String customerName, String transportName) throws SQLException {
//		List<OrderDetail> searchResult = new ArrayList<>();
//		PreparedStatement stm = null;
//		try {
//			StringBuffer sql = new StringBuffer(SEARCH_ORDER_SQL);
//			if (id > 0) {
//
//				sql.append(SEARCH_ORDER_ID_CONDITION_SQL.replaceAll("[?]", String.valueOf(id)));
//			}
//			if (customerName != null && customerName.trim().length() != 0) {
//				sql.append(SEARCH_ORDER_PARTY_NAME_CONDITION_SQL.replaceAll("[?]", DBUtility.toDBString(customerName)));
//			}
//			if (transportName != null && transportName.trim().length() != 0) {
//				sql.append(
//						SEARCH_ORDER_TRANSPORT_NAME_CONDITION_SQL.replaceAll("[?]", DBUtility.toDBString(transportName)));
//			}
//			sql.append(SEARCH_ORDER_SORT_SQL);
//
//			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(sql.toString());
//
//			ResultSet rs = stm.executeQuery();
//
//			while (rs.next()) {
//				Conversion.toOrderTransports(rs, searchResult);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			stm.close();
//		}
//
//		return searchResult;
//	}
}
