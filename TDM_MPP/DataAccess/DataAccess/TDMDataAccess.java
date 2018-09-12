package DataAccess;

import java.sql.*;

public class TDMDataAccess {
	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://127.0.0.1:3306/TDM?useSSL=false","root","root");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Bike");  
			System.out.println(rs);
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){
			System.out.println(e);
		}  
	}  
}
