package DataAccess;

import java.sql.*;

import Utilities.DatabaseConnection;

public class TDMDataAccess {
	public static void main(String args[]) throws SQLException{ 
		Connection con = null;
		Statement stmt= null;
		try{  
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con=DriverManager.getConnection(  
//			"jdbc:mysql://172.19.144.203:3306/TDM?useSSL=false","root","root");  
			
			con = DatabaseConnection.getInstance().getConnection();
			stmt=con.createStatement();  
			String sql = "INSERT INTO PARTY (NAME, PHONE, EMAIL, BIRTHDATE, PASSWORD, TYPE, HOBBIES, MARRIAGE_STATUS) " + 
					"VALUES ('Kien PHam1', '6122242661', '', null, '', 1,'', 1);";
			boolean value = stmt.execute(sql);
			ResultSet rs=stmt.executeQuery("select * from Party");  
			System.out.println(value);
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			stmt.close();  
		}catch(Exception e){
			System.out.println(e);
		} finally {
			con.close();
			stmt.close();
		}
	}  
}
