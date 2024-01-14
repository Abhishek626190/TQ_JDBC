package com.hospital_doctor_patient;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection con=Database_Connect.getMySqlConnection();
			
			System.out.println(con);
			
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}

}
