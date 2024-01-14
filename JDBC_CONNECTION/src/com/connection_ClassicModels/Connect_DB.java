package com.connection_ClassicModels;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

public class Connect_DB {

	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/classicmodels";
		String userName="root";
		String passWord="root";
		
		con=DriverManager.getConnection(url,userName,passWord);
		
		return con;
	}

//	public static Connection connectionSql()
//			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		Connection con = null;
//		Driver d = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//		Properties p = new Properties();
//		p.put("user", "root");
//		p.put("password", "root");
//
//		con = d.connect("jdbc:mysql://localhost:3306/classicmodels", p);
//
//		return con;
//
//	}

}
