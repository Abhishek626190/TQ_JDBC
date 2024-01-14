package com.Connection_TestCourseDB;

import java.util.Map.Entry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EmpDptMapDemo {

	Connection con;
	ResultSet resemp, resdpt;
	Statement semp, sdpt;
	String sqlemp, sqldpt;
	HashMap<String, ArrayList<String>> hmap = new HashMap<>();

	public void empDptDemp() throws ClassNotFoundException, SQLException {
		con = MySqlConnection.getMySqlConnection();
		sqlemp = "select * from employees";
		sqldpt = "select * from departments";
		semp = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		resemp = semp.executeQuery(sqlemp);
		sdpt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		resdpt = sdpt.executeQuery(sqldpt);

	}

	public void createMapDemo() throws SQLException {
		int dptId = 0;
		String dptName = null;
		while (resdpt.next()) {
			dptId = resdpt.getInt(1);
			ArrayList<String> enames = new ArrayList<>();
			resemp.beforeFirst();
			while (resemp.next()) {
				if (resemp.getInt(11) == dptId) {
					dptName = resdpt.getString(2);
					enames.add(resemp.getString(2));
				}

			}
			hmap.put(dptName, enames);
		}
	}

	public void show() {
		Set<Entry<String, ArrayList<String>>> set = hmap.entrySet();
		Iterator<Entry<String, ArrayList<String>>> itr = set.iterator();
		while (itr.hasNext()) {
			Entry<String, ArrayList<String>> e = itr.next();
			if (e.getValue().size() > 0) {
				String DepartmentName = e.getKey();
				ArrayList<String> al = e.getValue();
				System.out.println(DepartmentName);
				System.out.println(al);
			}
		}

	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		EmpDptMapDemo obj = new EmpDptMapDemo();
		obj.empDptDemp();
		obj.createMapDemo();
		obj.show();

	}

}
