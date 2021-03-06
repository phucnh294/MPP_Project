/**
 * 
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.SQLConstants;
import Data.Transport;
import Interface.ITransport;
import Utilities.Conversion;
import Utilities.DatabaseConnection;

/**
 * @author ptkie
 *
 */
public class TransportDAO implements SQLConstants, ITransport {

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
			stm.setString(4, transport.getModel());
			stm.setString(5, transport.getManufactor());
			stm.setString(6, transport.getDescription());
			stm.setInt(7, transport.getSeatCapacity());
			stm.setString(8, transport.getFuelType());
			stm.setDouble(9, transport.getMileage());
			stm.setInt(10, transport.getTranmissionType());
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
			stm.setString(4, transport.getModel());
			stm.setString(5, transport.getManufactor());
			stm.setString(6, transport.getDescription());
			stm.setInt(7, transport.getSeatCapacity());
			stm.setString(8, transport.getFuelType());
			stm.setDouble(9, transport.getMileage());
			stm.setInt(10, transport.getTranmissionType());
			stm.setInt(11, transport.getNumberOfEngine());
			stm.setString(12, transport.getTransportType());
			stm.setInt(13, transport.getId());
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
	 */
	public void deleteTransport(Transport transport) {
		PreparedStatement stm = null;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_TRANSPORT_SQL);
			stm.setInt(1, transport.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
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

				sql.append(SEARCH_TRANSPORT_FROM_PRICE_CONDITION_SQL.replaceAll("[?]", String.valueOf(fromPrice)));
			}
			if (toPrice > 0) {
				sql.append(SEARCH_TRANSPORT_TO_PRICE_CONDITION_SQL.replaceAll("[?]", String.valueOf(toPrice)));
			}
			if (manufacturer != null && manufacturer.trim().length() != 0) {
				sql.append(SEARCH_TRANSPORT_MANUFACTURER_CONDITION_SQL.replaceAll("[?]", manufacturer));
			}
			if (seatCapacity > 0) {
				sql.append(
						SEARCH_TRANSPORT_SEAT_CAPACITY_CONDITION_SQL.replaceAll("[?]", String.valueOf(seatCapacity)));
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

	public List<Transport> searchTransport(String name, String brand, String model) {
		List<Transport> searchResult = new ArrayList<>();
		PreparedStatement stm = null;
		try {
			StringBuffer sql = new StringBuffer(SEARCH_TRANSPORT_SQL);
			if (name != null && name.trim().length() > 0) {

				sql.append(SEARCH_TRANSPORT_NAME_CONDITION_SQL.replaceAll("[?]", name));
			}
			if (brand != null && brand.trim().length() > 0) {
				sql.append(SEARCH_TRANSPORT_BRAND_CONDITION_SQL.replaceAll("[?]", brand));
			}
			if (model != null && model.trim().length() > 0) {
				sql.append(SEARCH_TRANSPORT_MODEL_CONDITION_SQL.replaceAll("[?]", model));
			}

			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(sql.toString());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				searchResult.add(Conversion.toTransport(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return searchResult;
	}
}
