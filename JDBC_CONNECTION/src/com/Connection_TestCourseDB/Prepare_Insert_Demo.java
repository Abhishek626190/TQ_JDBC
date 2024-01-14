package com.Connection_TestCourseDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Prepare_Insert_Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		try
		{
		Connection con=MySqlConnection.getMySqlConnection();
		String sql=" insert into departments "
					+ " values (?,?,?,?)";
		//System.out.println(sql);
		PreparedStatement pstat=con.prepareCall(sql);
		pstat.setInt(1,290);
		pstat.setString(2,"Tester");
		pstat.setInt(3,206);
		pstat.setInt(4,1800);
		
		int cnt=pstat.executeUpdate();
		System.out.println(cnt+" Insert the data");
		
		pstat.close();
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}



	}

}
