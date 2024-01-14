package com.hospital_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Create Connection with hospital database.
public class ConnectDatabase {
	
	public static Connection getSqlConnection() throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/hospital";
		String userName="root";
		String password="root";
		
		con=DriverManager.getConnection(url,userName,password);
		
		return con;
	}
	

}
