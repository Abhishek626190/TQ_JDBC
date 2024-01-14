package com.hospital_Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//Show all records
public class Show_Records {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Connection con=ConnectDatabase.getSqlConnection();
		System.out.println(con);
		String sql="Select pname from patient";
		Statement stat=con.createStatement();
		ResultSet rs=stat.executeQuery(sql);
		while(rs.next())
		{
			String name=rs.getString(1);
			System.out.println(name);
			System.out.println("************");
		}
		rs.close();
		con.close();
		stat.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
