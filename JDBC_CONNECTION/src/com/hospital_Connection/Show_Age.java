package com.hospital_Connection;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//List All Patient details with age above 50
public class Show_Age {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Connection con=ConnectDatabase.getSqlConnection();
			String sql="select pname,age"
					+ " from patient"
					+ " where age >?";
			
			PreparedStatement pstat=con.prepareCall(sql);
			pstat.setInt(1, 30);
			
			ResultSet rs=pstat.executeQuery();
			while(rs.next())
			{
				String name=rs.getString(1);
				int age=rs.getInt(2);
				System.out.println("Name:"+name+"\nAge:"+age);
				System.out.println("***********");
			}
			rs.close();
			pstat.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
