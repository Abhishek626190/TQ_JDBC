package com.hospital_doctor_patient;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

public class CountFunctionCall {
	
	Connection con;
	
	public void getCount()
	{
		try {
			con=Database_Connect.getMySqlConnection();
			CallableStatement cs=con.prepareCall("{?=call count_Patient(?)}");
			cs.registerOutParameter(1, Types.INTEGER);
// 			cs.setDate(2,java.sql.Date.valueOf("2023-01-15"));
 			Date d=Date.valueOf("2023-01-15");
 			cs.setDate(2, d);

			cs.execute();
			System.out.println("The count of patient: "+cs.getInt(1));
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
		CountFunctionCall obj=new CountFunctionCall();
		obj.getCount();
	}

}
