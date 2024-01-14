package com.Connection_TestCourseDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class Delete_Emp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Connection con=MySqlConnection.getMySqlConnection();
		String sql="delete from employees where salary=0 ";
		PreparedStatement pstat=con.prepareCall(sql);
		int  cnt=pstat.executeUpdate();
		System.out.println(cnt+" Row Affected");
		con.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
