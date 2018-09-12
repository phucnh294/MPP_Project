/**
 * 
 */
package User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Common.Conversion;
import Common.SQLConstants;
import Utilities.DatabaseConnection;

/**
 * @author ptkie
 *
 */
public class UserModel implements SQLConstants {

	/**
	 * login
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Dealer login(String username, String password) throws SQLException {

		Statement stm = null;
		ResultSet rs;
		try {
			stm = DatabaseConnection.getInstance().getConnection().createStatement();
			rs = stm.executeQuery(SIGNIN_SQL);
			if (rs.next()) {
				
				return Conversion.toDealer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stm.close();
		}

		return null;
	}

}
