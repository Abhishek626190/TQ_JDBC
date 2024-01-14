package com.hospital_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;
//4.	Update email address of patient whose name is ‘K.V.Naik’.
//  Use Statement object to do the same. 
public class UpdateEmail {
	Scanner sc=new Scanner(System.in);
	public void update()
	{
	try {
		Connection con=ConnectDatabase.getSqlConnection();
		System.out.println("Enter Patient Name to update Email: ");
		String name=sc.next();
		System.out.println("Enter New E-Mail: ");
		String mail=sc.next();
		String sql="update patient "
				+ " set email= ? "
						+ " where pname=?";
		//Statement stat=con.createStatement();
		//int cnt=stat.executeUpdate(sql);
		PreparedStatement pstat=con.prepareCall(sql);
		pstat.setString(1, mail);
		pstat.setString(2, name);
		int cnt=pstat.executeUpdate();
		System.out.println(cnt+" Rows Affected");
		
		pstat.close();
		con.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateEmail obj=new UpdateEmail();
		obj.update();
		

	}

}
