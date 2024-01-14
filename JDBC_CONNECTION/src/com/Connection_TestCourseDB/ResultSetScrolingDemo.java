package com.Connection_TestCourseDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetScrolingDemo {
	String sql ;
	Connection con;
	ResultSet rs;
	Statement stat;

	public ResultSetScrolingDemo() {
		try {
			con = MySqlConnection.getMySqlConnection();
			stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sql = "Select employee_id,first_name,salary,department_id" 
					+ " from employees ";
			rs = stat.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showScrollingDataInForward() throws SQLException {
		System.out.println("__________________________________________________");
		System.out.println("Emp ID" + "\t" + "Name" + "\t\t" + "Salary" + "\t\tDept No");
		System.out.println("__________________________________________________");

		while (rs.next()) {
			System.out
					.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t" + rs.getInt(4));

		}
	}
	public void showScrollingDataReverse() throws SQLException
	
	{
		System.out.println("__________________________________________________");
		System.out.println("Emp ID" + "\t" + "Name" + "\t\t" + "Salary" + "\t\tDept No");
		System.out.println("__________________________________________________");
		rs.afterLast();
		while(rs.previous())
		{
			System.out
			.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t\t" + rs.getInt(4));

		}
	}
	
	public void showAbsolutePosition(int i) throws SQLException
	{
		rs.beforeFirst();
		rs.absolute(i);
		System.out.println("Record in "+i+ " Position ");
		System.out.println("__________________________________________________");
		System.out.println("Emp ID" +"\t"+"Name"+"\t\t"+"Salary"+"\t\tDept No");
		System.out.println("__________________________________________________");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getDouble(3)+"\t\t"+rs.getInt(4));

	}
	public void showRelativePosition(int i) throws SQLException
	{
		 
		//rs.beforeFirst();
		rs.relative(i);
		System.out.println("Record in "+i+ " Position ");
		System.out.println("__________________________________________________");
		System.out.println("Emp ID" +"\t"+"Name"+"\t\t"+"Salary"+"\t\tDept No");
		System.out.println("__________________________________________________");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getDouble(3)+"\t\t"+rs.getInt(4));

	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ResultSetScrolingDemo obj = new ResultSetScrolingDemo();
		//obj.showScrollingDataInForward();
		//obj.showScrollingDataReverse();
		obj.showAbsolutePosition(5);
		obj.showRelativePosition(5);

	}

}
