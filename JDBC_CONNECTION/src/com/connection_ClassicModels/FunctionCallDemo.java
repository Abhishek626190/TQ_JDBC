package com.connection_ClassicModels;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionCallDemo {
	public void funCall()
	{
		Connection con;
		
		try {
			con=Connect_DB.getConnection();
			
			CallableStatement cs=con.prepareCall("{?=call getOfficeCode(?)}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, 1102);
			cs.execute();
			System.out.println(cs.getInt(1));
			
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
		FunctionCallDemo obj=new FunctionCallDemo();
		obj.funCall();

	}

}
