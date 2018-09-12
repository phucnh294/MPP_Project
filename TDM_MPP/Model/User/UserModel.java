/**
 * 
 */
package User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

		PreparedStatement stm = null;
		ResultSet rs;
		try {
			stm = DatabaseConnection.getInstance().getConnection().prepareStatement(SIGNIN_SQL);
			stm.setString(1, username);
			stm.setString(2, password);
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
