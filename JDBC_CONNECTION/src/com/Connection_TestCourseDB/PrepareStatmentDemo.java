package com.Connection_TestCourseDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatmentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con=MySqlConnection.getMySqlConnection();
			String sql ="select employee_id,salary "
					    + "from employees "
					    + "where salary > ?";
			System.out.println(sql);
			PreparedStatement pstat=con.prepareCall(sql);
			pstat.setDouble(1,30000);
			
			ResultSet rs=pstat.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				double sal=rs.getDouble(2);
				 System.out.println("Employee_Id"+id);
				 System.out.println("Employee_Salary"+sal);
				 System.out.println("*************");
 
			}
			rs.close();
			con.close();
			pstat.close();
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
