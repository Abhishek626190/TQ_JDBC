package com.hospital_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
// 5.	Delete all records from patient 
//table for giben patient id. Use PreparedStatement for the same. 
public class Delete_Patient {
	Scanner sc=new Scanner(System.in);
	
	public void delete()
	{
		try {
			Connection con=ConnectDatabase.getSqlConnection();
			System.out.println("Enter Patient Id to Delete Patient Details: ");
			int id=sc.nextInt();
			String sql="delete from patient "
					+ " where pid=?";
			
			PreparedStatement pstat=con.prepareCall(sql);
			pstat.setInt(1, id);
			int cnt= pstat.executeUpdate();
			System.out.println(cnt+" Rows Affected");
			
			pstat.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Delete_Patient obj=new Delete_Patient();
		obj.delete();

	}

}
