package com.Connection_TestCourseDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	public static Connection getMySqlConnection() throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		
		//load the driver 
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		// get the connection
		String url="jdbc:mysql://localhost:3306/testcoursedb";
		String userName="root";
		String password="root";
		
		con=DriverManager.getConnection(url,userName,password);
		
		return con;
				
	}

}
