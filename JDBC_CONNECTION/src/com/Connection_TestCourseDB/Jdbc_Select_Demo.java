package com.Connection_TestCourseDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_Select_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Connection con=MySqlConnection.getMySqlConnection();
			//System.out.println(con);
			String sql="select * from departments";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
				System.out.println("**********");
			}
			
			rs.close();
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
