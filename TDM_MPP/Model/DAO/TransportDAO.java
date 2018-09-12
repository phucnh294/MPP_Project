/**
 * 
 */
package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.Conversion;
import Common.SQLConstants;
import Utilities.DBUtility;
import Utilities.DatabaseConnection;
import Vehicle.Transport;

/**
 * @author ptkie
 *
 */
public class TransportDAO implements SQLConstants {

	/**
	 * insert a new party
	 * 
	 * @param party
	 * @throws SQLException
	 */
	public void insertTransport(Transport transport) throws SQLException {
		PreparedStatement stm = null;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_TRANSPORT_SQL);
			stm.setString(1, transport.getName());
			stm.setDouble(2, transport.getPrice());
			stm.setString(3, transport.getBrand());
			stm.setDate(4, Date.valueOf(transport.getCreatedDate()));
			stm.setString(5, transport.getModel());
			stm.setString(6, transport.getManufactor());
			stm.setString(7, transport.getDescription());
			stm.setInt(8, transport.getSeatCapacity());
			stm.setString(9, transport.getFuelType());
			stm.setDouble(10, transport.getMileage());
			stm.setInt(11, transport.getNumberOfEngine());
			stm.setString(12, transport.getTransportType());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}
	}

	/**
	 * update a given transport
	 * 
	 * @param transport
	 * @throws SQLException
	 */
	public void updateTransport(Transport transport) throws SQLException {
		PreparedStatement stm = null;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_TRANSPORT_SQL);
			stm.setString(1, transport.getName());
			stm.setDouble(2, transport.getPrice());
			stm.setString(3, transport.getBrand());
			stm.setDate(4, Date.valueOf(transport.getCreatedDate()));
			stm.setString(5, transport.getModel());
			stm.setString(6, transport.getManufactor());
			stm.setString(7, transport.getDescription());
			stm.setInt(8, transport.getSeatCapacity());
			stm.setString(9, transport.getFuelType());
			stm.setDouble(10, transport.getMileage());
			stm.setInt(11, transport.getNumberOfEngine());
			stm.setInt(12, transport.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}

	}

	/**
	 * delete a given transport
	 * 
	 * @param party
	 * @throws SQLException
	 */
	public void deleteTransport(Transport transport) throws SQLException {
		PreparedStatement stm = null;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_TRANSPORT_SQL);
			stm.setInt(1, transport.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
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
	public List<Transport> search(double fromPrice, double toPrice, String manufacturer, int seatCapacity)
			throws SQLException {
		List<Transport> searchResult = new ArrayList<>();
		PreparedStatement stm = null;
		try {
			StringBuffer sql = new StringBuffer(SEARCH_TRANSPORT_SQL);
			if (fromPrice >= 0) {

				sql.append(SEARCH_TRANSPORT_FROM_PRICE_CONDITION_SQL.replaceAll("?", String.valueOf(fromPrice)));
			}
			if (toPrice > 0) {
				sql.append(SEARCH_PARTY_NAME_CONDITION_SQL.replaceAll("?", String.valueOf(toPrice)));
			}
			if (manufacturer != null) {
				sql.append(SEARCH_PARTY_EMAIL_CONDITION_SQL.replaceAll("?", DBUtility.toDBString(manufacturer)));
			}
			if (seatCapacity > 0) {
				sql.append(SEARCH_PARTY_PHONE_CONDITION_SQL.replaceAll("?", String.valueOf(seatCapacity)));
			}
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(sql.toString());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				searchResult.add(Conversion.toTransport(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}

		return searchResult;
	}
}
