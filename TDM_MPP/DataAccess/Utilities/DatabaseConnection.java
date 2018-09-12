/**
 * 
 */
package Utilities;

/**
 * @author ptkie
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static DatabaseConnection instance;
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/TDM?useSSL=false";
	private String username = "root";
	private String password = "root";

	private DatabaseConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DatabaseConnection getInstance() throws SQLException {
		if (instance == null || instance.getConnection().isClosed()) {
			instance = new DatabaseConnection();
		} 

		return instance;
	}
}
