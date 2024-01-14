package com.connection_ClassicModels;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
//Procedure Call
public class CallableStatementDemo {
	
	public void procedureCallDemo()
	{
		Connection con;
		try {
			 con=Connect_DB.getConnection();
			 CallableStatement cs=con.prepareCall("{call if_else_demo(?,?)}");
			 cs.setInt(1, 101);
			 cs.registerOutParameter(2, Types.VARCHAR);
			 cs.execute();
			 System.out.println("Customer Level: "+cs.getString(2));
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
		CallableStatementDemo obj=new CallableStatementDemo();
		obj.procedureCallDemo();
	}

}
