package com.hospital_doctor_patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
// 4.	Create a HashMap with doctorId as key and list of 
//  patients treated by that doctors as value. Show all entries in HashMap. 
public class DoctorId_PatientList {

	Connection con;
	Statement stat;
	ResultSet rs;

	HashMap<Integer, ArrayList<String>> doctorMap = new HashMap<>();

	public void getDoctorPatient() {
		try {
			con = Database_Connect.getMySqlConnection();
			String sql = "select docid ,group_concat(pname) " + " from patient " + " inner join doctor using(docid) "
					+ " group by docid;";

			stat = con.createStatement();
			rs = stat.executeQuery(sql);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createMap() throws SQLException {
		int dId = 0;
		String pName = null;

		while (rs.next()) {
			dId = rs.getInt(1);
			pName = rs.getString(2);
			ArrayList<String> pNames = new ArrayList<>();
			pNames.add(pName);
			doctorMap.put(dId, pNames);

		}
	}

	public void printMap() {
		Set<Entry<Integer, ArrayList<String>>> set = doctorMap.entrySet();
		Iterator<Entry<Integer, ArrayList<String>>> itr = set.iterator();
		while (itr.hasNext()) {
			Entry<Integer, ArrayList<String>> e = itr.next();
			int id = e.getKey();
			ArrayList<String> al = e.getValue();
			System.out.println("Doctor Id: " + id);
			System.out.println("Patients Treated By That Doctor: " + al);
		}

	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DoctorId_PatientList obj=new DoctorId_PatientList();
		obj.getDoctorPatient();
		obj.createMap();
		obj.printMap();
		

	}

}
