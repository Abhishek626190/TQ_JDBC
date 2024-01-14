package com.hospital_doctor_patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;


public class DoctorId_PatientList_2 {

	Connection con;
	ResultSet resdoc, respat;
	Statement sdoc, spat;
	String sqldoc, sqlpat;
	HashMap<Integer, ArrayList<PatientObject>> hmap = new HashMap<>();

	public void docPatData() throws ClassNotFoundException, SQLException {
		con = Database_Connect.getMySqlConnection();
		sqldoc = "select * from doctor";
		sqlpat= "select * from patient";
		sdoc = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		resdoc = sdoc.executeQuery(sqldoc);
		spat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		respat = spat.executeQuery(sqlpat);

	}

	public void createMapDemo() throws SQLException {
		int docId = 0;
		//String patName = null;
		while (resdoc.next()) {
			docId = resdoc.getInt(1);
			ArrayList<PatientObject> enames = new ArrayList<>();
			respat.beforeFirst();
			while (respat.next()) {
				if (respat.getInt(7) == docId) {
					//patName = respat.getString(2);
					//enames.add(respat.getString(2));
					PatientObject p=new PatientObject(respat.getInt(1), respat.getString(2), respat.getInt(3), respat.getFloat(4), respat.getString(5), respat.getDate(6), respat.getInt(7));
					enames.add(p);
					
				}

			}
			hmap.put(docId, enames);
		}
	}

	public void show() {
		Set<Entry<Integer, ArrayList<PatientObject>>> set = hmap.entrySet();
		Iterator<Entry<Integer, ArrayList<PatientObject>>> itr = set.iterator();
		while (itr.hasNext()) {
			Entry<Integer, ArrayList<PatientObject>> e = itr.next();
			if (e.getValue().size() > 0) {
				Integer did = e.getKey();
				ArrayList<PatientObject> al = e.getValue();
				System.out.println("Doctor Id: "+did);
				//System.out.println();
				System.out.println("Patient List: "+al);
				System.out.println("***********");
			}
		}

	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		DoctorId_PatientList_2 obj = new DoctorId_PatientList_2();
		obj.docPatData();
		obj.createMapDemo();
		obj.show();

	}

	
}
