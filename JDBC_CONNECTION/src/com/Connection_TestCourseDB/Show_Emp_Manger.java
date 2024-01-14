package com.Connection_TestCourseDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

//2.WAP using JDBC to select and print employee names along with their manager names.
public class Show_Emp_Manger {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		try
		{
		Connection con=MySqlConnection.getMySqlConnection();
		String sql="select e.first_name as Employee_Name,e1.first_name as Manager_Name "
				+ "from employees e "
				+ " join employees e1 "
				+ " on e.manager_id=e1.employee_id";
		System.out.println(sql);
		PreparedStatement pstat=con.prepareCall(sql);
		ResultSet rs=pstat.executeQuery();
		while(rs.next())
		{
			String emp_name=rs.getString(1);
			String man_name=rs.getString(2);
			System.out.println("Employee_Name"+emp_name);
			System.out.println("Manager_Name"+man_name);
			System.out.println("***********");

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
