package Common;

import java.sql.ResultSet;
import java.sql.SQLException;

import User.Party;
import Vehicle.Transport;

public class Conversion implements SQLConstants {

	public static Party toParty(ResultSet rs) {
		if (rs == null) return null;
		
		Party party = new Party();
		try {
			party.setCustomerId(rs.getInt(ID_PARTY_COLUMN));
			party.setName(rs.getString(NAME_PARTY_COLUMN));
			party.setPhone(rs.getString(PHONE_PARTY_COLUMN));
			party.setEmail(rs.getString(EMAIL_PARTY_COLUMN));
			party.setBirthDate(rs.getDate(BIRTHDATE_PARTY_COLUMN).toLocalDate());
			party.setPassword(rs.getString(PASSWORD_PARTY_COLUMN));
			party.setType(rs.getString(TYPE_PARTY_COLUMN));
			party.setHobbies(rs.getString(HOBBIES_PARTY_COLUMN));
			party.setMarriageStatus(rs.getInt(MARRIAGE_STATUS_PARTY_COLUMN));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return party;
	}
	
	/**
	 * Convert data in resultset to transport object
	 * 
	 * @param rs
	 * @return
	 */
	public static Transport toTransport(ResultSet rs) {
		if (rs == null) return null;
		
		Transport transport = new Transport();
		try {
			transport.setBrand(rs.getString(BRAND_TRANSPORT_COLUMN));
			transport.setCreatedDate(rs.getDate(DATE_CREATED_TRANSPORT_COLUMN).toLocalDate());
			transport.setDescription(rs.getString(DESCRIPTION_TRANSPORT_COLUMN));
			transport.setFuelType(rs.getInt(FUEL_TYPE_TRANSPORT_COLUMN));
			transport.setId(rs.getInt(ID_TRANSPORT_COLUMN));
			transport.setManufactor(rs.getString(MANUFACTURER_TRANSPORT_COLUMN));
			transport.setMileage(rs.getDouble(MILEAGE_TRANSPORT_COLUMN));
			transport.setModel(rs.getString(MODEL_TRANSPORT_COLUMN));
			transport.setName(rs.getString(NAME_TRANSPORT_COLUMN));
			transport.setNumberOfEngine(rs.getInt(NUMBER_OF_ENGINE_TRANSPORT_COLUMN));
			transport.setPrice(rs.getDouble(PRICE_TRANSPORT_COLUMN));
			transport.setSeatCapacity(rs.getInt(SEAT_CAPACITY_TRANSPORT_COLUMN));
			transport.setTranmissionType(rs.getInt(TRANMISSION_TYPE_TRANSPORT_COLUMN));
			transport.setTransportType(rs.getInt(TRANSPORT_TYPE_TRANSPORT_COLUMN));
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
		return transport;
	}
}
