package com.hospital_doctor_patient;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallProcedurePatient {
	
	Connection con;
	public void getPatient()
	{
		try {
			con=Database_Connect.getMySqlConnection();
			CallableStatement cs=con.prepareCall("{call getPatientDetails(?,?,?)}");
			cs.setInt(1, 101);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.execute();
			System.out.println("Patient Name:"+cs.getString(2));
 			System.out.println("Patient Age:"+cs.getInt(3));
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
		CallProcedurePatient obj=new CallProcedurePatient();
		obj.getPatient();

	}

}
