/**
 * 
 */
package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * @author ptkie
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

	private static DatabaseConnection instance;
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/TDM";
	private String username = "root";
	private String password = "root";

	private DatabaseConnection() throws SQLException {
		readSettings();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}

	private void readSettings() {
		Properties props = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("setting.properties");
			props.load(in);
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("setting.properties is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can not read setting.properties file");
			e.printStackTrace();
		}
		url = props.getProperty("jdbc.url", "jdbc:mysql://localhost:3306/TDM");
		username = props.getProperty("jdbc.username", "root");
		password = props.getProperty("jdbc.password", "root");

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
	
	public static void main(String[] args) throws SQLException {
		DatabaseConnection.getInstance();
	}
}
