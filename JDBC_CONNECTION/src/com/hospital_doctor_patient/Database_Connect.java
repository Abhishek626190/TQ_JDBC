package com.hospital_doctor_patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connect {
	
	public static Connection getMySqlConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/hospital_1";
		String username="root";
		String password="root";
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		return con;
	}
	

	  

}
