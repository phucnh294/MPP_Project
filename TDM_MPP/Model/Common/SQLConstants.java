/**
 * 
 */
package Common;

/**
 * @author ptkie
 *
 */
public interface SQLConstants {

	//PARTY COLUMNS
	String ID_PARTY_COLUMN = "ID";
	String NAME_PARTY_COLUMN = "NAME";
	String PHONE_PARTY_COLUMN = "PHONE";
	String EMAIL_PARTY_COLUMN = "EMAIL";
	String BIRTHDATE_PARTY_COLUMN = "BIRTHDATE";
	String PASSWORD_PARTY_COLUMN = "PASSWORD";
	String TYPE_PARTY_COLUMN = "TYPE";
	String HOBBIES_PARTY_COLUMN = "HOBBIES";
	String MARRIAGE_STATUS_PARTY_COLUMN = "MARRIAGE_STATUS";
	
	// TRANSPORT COLUMNS
	String ID_TRANSPORT_COLUMN = "ID";
	String NAME_TRANSPORT_COLUMN = "NAME";
	String PRICE_TRANSPORT_COLUMN = "PRICE";
	String BRAND_TRANSPORT_COLUMN = "BRAND";
	String DATE_CREATED_TRANSPORT_COLUMN = "DATE_CREATED";
	String MODEL_TRANSPORT_COLUMN = "MODEL";
	String MANUFACTURER_TRANSPORT_COLUMN = "MANUFACTURER";
	String DESCRIPTION_TRANSPORT_COLUMN = "DESCRIPTION";
	String SEAT_CAPACITY_TRANSPORT_COLUMN = "SEAT_CAPACITY";
	String FUEL_TYPE_TRANSPORT_COLUMN = "FUEL_TYPE";
	String MILEAGE_TRANSPORT_COLUMN = "MILEAGE";
	String TRANMISSION_TYPE_TRANSPORT_COLUMN = "TRANMISSION_TYPE";
	String NUMBER_OF_ENGINE_TRANSPORT_COLUMN = "NUMBER_OF_ENGINE";
	String TRANSPORT_TYPE_TRANSPORT_COLUMN = "TRANSPORT_TYPE";
	
	//ORDER COLUMNS
	String AMOUNT_ORDER_COLUMN = "AMOUNT";
	String ORDER_DATE_ORDER_COLUMN = "ORDER_DATE";
	String CUSTOMER_ID_ORDER_COLUMN = "CUSTOMER_ID";
	String DEALER_ID_ORDER_COLUMN = "DEALER_ID";
	String PARTY_NAME_ORDER_COLUMN = "PARTY_NAME";
	String TRANSPORT_ID_ORDER_COLUMN = "TRANSPORT_ID";
	String TRANSPORT_NAME_ORDER_COLUMN = "TRANSPORT_NAME";
	String ID_ORDER_COLUMN = "ID";
	
	//SIGN IN
	String SIGNIN_SQL = "Select * From Party Where email = ? and password = ?";

	// PARTY
	String INSERT_PARTY_SQL = "INSERT INTO PARTY (NAME, PHONE, EMAIL, PASSWORD, TYPE, HOBBIES, MARRIAGE_STATUS) VALUES(?,?,?,?,?,?,?)";
	String UPDATE_PARTY_SQL = "UPDATE PARTY SET NAME = ?, PHONE = ?, EMAIL = ?, PASSWORD = ?, TYPE = ?, HOBBIES = ?, MARRIAGE_STATUS = ? WHERE ID = ?";
	String DELETE_PARTY_SQL = "DELETE FROM PARTY WHERE ID = ?";
	String SEARCH_PARTY_SQL = "SELECT * FROM PARTY WHERE 1=1 ";
	String SEARCH_PARTY_ID_CONDITION_SQL = " AND ID = ? ";
	String SEARCH_PARTY_NAME_CONDITION_SQL = " AND NAME LIKE '%?%' ";
	String SEARCH_PARTY_EMAIL_CONDITION_SQL = " AND EMAIL LIKE '%?%'";
	String SEARCH_PARTY_PHONE_CONDITION_SQL = " AND PHONE LIKE '%?%'";

	// TRANSPORT
	String INSERT_TRANSPORT_SQL = "INSERT INTO TRANSPORT (NAME, PRICE,	BRAND,	MODEL,	MANUFACTURER,	DESCRIPTION,	SEAT_CAPACITY,	FUEL_TYPE,	MILEAGE, TRANMISSION_TYPE, NUMBER_OF_ENGINE, TRANSPORT_TYPE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	String UPDATE_TRANSPORT_SQL = "UPDATE TRANSPORT SET NAME = ?, PRICE=?, BRAND=?, MODEL=?, MANUFACTURER=?, DESCRIPTION=?, SEAT_CAPACITY=?, FUEL_TYPE=?, MILEAGE=?, TRANMISSION_TYPE=?, NUMBER_OF_ENGINE = ? WHERE ID=?";
	String DELETE_TRANSPORT_SQL = "DELETE FROM TRANSPORT WHERE ID = ?";
	String SEARCH_TRANSPORT_SQL = "SELECT * FROM TRANSPORT WHERE 1=1 ";
	String SEARCH_TRANSPORT_FROM_PRICE_CONDITION_SQL = " AND ? <= PRICE ";
	String SEARCH_TRANSPORT_TO_PRICE_CONDITION_SQL = " AND PRICE <= ? ";
	String SEARCH_TRANSPORT_MANUFACTURER_CONDITION_SQL = " AND MANUFACTURER LIKE '%?%' ";
	String SEARCH_TRANSPORT_SEAT_CAPACITY_CONDITION_SQL = " AND SEAT_CAPACITY = ? ";
	
	String INSERT_ORDER_SQL = "INSERT INTO ORDER_ (AMOUNT, ORDER_DATE, CUSTOMER_ID, DEALER_ID) VALUES (?, ?, ?, ?)";
	String UPDATE_ORDER_SQL = "UPDATE ORDER_ SET AMOUNT =?, ORDER_DATE=?, CUSTOMER_ID=?, DEALER_ID=? WHERE ID = ?";
	String DELETE_ORDER_SQL = "DELETE FROM ORDER_ WHERE ID = ?";
	String SEARCH_ORDER_SQL = "SELECT ORD.ID, ORD.AMOUNT, ORD.CUSTOMER_ID, ORD.DEALER_ID," + 
			"P.NAME PARTY_NAME, P.PHONE, P.EMAIL, P.BIRTHDATE, P.PASSWORD, P.TYPE, P.HOBBIES, P.MARRIAGE_STATUS," + 
			"OP.TRANSPORT_ID, OP.PRICE," + 
			"TRANS.NAME TRANSPORT_NAME, TRANS.BRAND, TRANS.DATE_CREATED, TRANS.MODEL, TRANS.MANUFACTURER, " + 
			"TRANS.DESCRIPTION, TRANS.SEAT_CAPACITY, TRANS.FUEL_TYPE, TRANS.MILEAGE, TRANS.TRANMISSION_TYPE, TRANS.NUMBER_OF_ENGINE, TRANS.TRANSPORT_TYPE" + 
			"FROM ORDER_ ORD " + 
			"LEFT JOIN PARTY P ON ORD.CUSTOMER_ID = P.ID " + 
			"LEFT JOIN ORDER_TRANSPORT OP ON ORD.ID = OP.ORDER_ID " + 
			"LEFT JOIN TRANSPORT TRANS ON TRANS.ID = OP.TRANSPORT_ID" + 
			"WHERE 1=1 ";
	String SEARCH_ORDER_PARTY_NAME_CONDITION_SQL = " AND P.NAME LIKE '%?%' ";
	String SEARCH_ORDER_TRANSPORT_NAME_CONDITION_SQL = " AND TRANS.NAME LIKE '%?%' ";
	String SEARCH_ORDER_ID_CONDITION_SQL = " AND ORD.ID = ? ";
	String SEARCH_ORDER_SORT_SQL = " ORDER BY ORD.ID ";
	
	String INSERT_ORDER_TRANSPORT_SQL = "INSERT INTO ORDER_TRANSPORT(ORDER_ID, TRANSPORT_ID, PRICE) VALUES(?, ?, ?)";
	String DELETE_ORDER_TRANSPORT_SQL = "DELETE FROM ORDER_TRANSPORT WHERE ORDER_ID = ?";
	
	

}
