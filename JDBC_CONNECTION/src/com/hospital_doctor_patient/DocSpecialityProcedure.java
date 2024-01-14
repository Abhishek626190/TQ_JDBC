package com.hospital_doctor_patient;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class DocSpecialityProcedure {

	Connection con;
	public void getSpeciality()
	{
		try {
			con=Database_Connect.getMySqlConnection();
			CallableStatement cs=con.prepareCall("{ call getDoctorSpeciality(?,?)}");
			cs.setInt(1, 1);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			System.out.println(cs.getString(2));
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
		DocSpecialityProcedure obj=new DocSpecialityProcedure();
		
		obj.getSpeciality();
	}

}
