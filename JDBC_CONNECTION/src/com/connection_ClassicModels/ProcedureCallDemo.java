package com.connection_ClassicModels;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureCallDemo {

	public void procedureCallMethod() {
		Connection con;
		try {
			con = Connect_DB.getConnection();

			CallableStatement cs = con.prepareCall("{call getCountOfEmployee(?)}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			int cnt = cs.getInt(1);
			System.out.println("Total Number Of Employees = " + cnt);
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
		ProcedureCallDemo obj=new ProcedureCallDemo();
		
		obj.procedureCallMethod();

	}

}
