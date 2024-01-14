package com.Connection_TestCourseDB;

import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.Statement;

public class Insert_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Connection con=MySqlConnection.getMySqlConnection();
			//System.out.println(con);
			String sql="insert into Departments values(1001,'Hr',786,144)";
			Statement st=con.createStatement();
 			
			int cnt=st.executeUpdate(sql);
			System.out.println(cnt+" insert the data");
		
 			st.close();
			con.close();
 			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
