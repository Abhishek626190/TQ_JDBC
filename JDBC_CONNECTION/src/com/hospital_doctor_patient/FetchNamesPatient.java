package com.hospital_doctor_patient;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import java.sql.Statement;

// 2.	Fetch  Patient names admitted after 5th May 2020 and age 
//above 50 and store it in ArrayList. 
public class FetchNamesPatient {

	Connection con;
	Statement pstat;
	ResultSet rs;
	ArrayList<String> patientList = new ArrayList<>();

	public void fetchPatient() {
		try {
			con = Database_Connect.getMySqlConnection();
			// System.out.println(con);
			String sql = "select pname,pid from patient " + " where age>35 and admissionDate>'2023-01-15' ";

			// System.out.println(sql);
			pstat = con.createStatement();
			rs = pstat.executeQuery(sql);

			while (rs.next()) {
				// String name = rs.getString(1);
				String name = rs.getString("pname");
				// int id=rs.getInt(2);
				// System.out.println(id);
				patientList.add(name);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showPatient() {
		Iterator<String> itr = patientList.iterator();
		while (itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FetchNamesPatient obj = new FetchNamesPatient();
		obj.fetchPatient();
		obj.showPatient();

	}

}
