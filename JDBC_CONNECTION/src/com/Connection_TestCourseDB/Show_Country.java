package com.Connection_TestCourseDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 1.WAP using JDBC to select and print all country names.
public class Show_Country {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try
		{
		Connection con=MySqlConnection.getMySqlConnection();
		String sql="select distinct country_name from countries";
		PreparedStatement pstat=con.prepareCall(sql);
		
		ResultSet rs=pstat.executeQuery();
		while(rs.next())
		{
			String name=rs.getString(1);
			System.out.println(name);
		}
		rs.close();
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
 	}

}
