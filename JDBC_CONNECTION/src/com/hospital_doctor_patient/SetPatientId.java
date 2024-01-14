package com.hospital_doctor_patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.TreeSet;

//5.Create a Set of patient id and sort it in descending order of patient ids.  
public class SetPatientId {

	Connection con;
	Statement stat;
	ResultSet rs;
	TreeSet<Integer> ts = new TreeSet<>(new Comparator_PatientId());

	public void getId() {
		try {
			con = Database_Connect.getMySqlConnection();
			String sql = "select pid from patient";
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

	public void createSet() throws SQLException {
		int pid = 0;
		while (rs.next()) {
			pid = rs.getInt(1);
			ts.add(pid);
		}
	}

	public void printSet() {
		Iterator<Integer> itr = ts.iterator();
		while (itr.hasNext()) {
			int id = itr.next();
			System.out.println("Patient Id " + id);
		}
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		SetPatientId obj = new SetPatientId();
		obj.getId();
		obj.createSet();
		obj.printSet();

	}

}
