package com.hospital_doctor_patient;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class HashMap_Patient {

	Connection con;
	ResultSet rs1;
	Statement stat1;
	String sql;

	HashMap<Integer, String> patientMap = new HashMap<>();

	public void patientData() throws SQLException {
		try {
			con = Database_Connect.getMySqlConnection();

			sql = "select pid, pName from patient";

			stat1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs1 = stat1.executeQuery(sql);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			 
		}
	}

	public void patientMap() throws SQLException {
		int pId = 0;
		String pName = null;

		while (rs1.next()) {
			pId = rs1.getInt(1);
			pName = rs1.getString(2);
			patientMap.put(pId, pName);

		}                  
	}

	public void showMapData() {
		Set<Entry<Integer, String>> set = patientMap.entrySet();
		Iterator<Entry<Integer, String>> itr = set.iterator();
		while (itr.hasNext()) {
			Entry<Integer, String> e = itr.next();
			int id = e.getKey();
			String name = e.getValue();
			System.out.println(id + " ***** " + name);
		}
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		HashMap_Patient obj = new HashMap_Patient();
		obj.patientData();
		obj.patientMap();
		obj.showMapData();

	}

}
