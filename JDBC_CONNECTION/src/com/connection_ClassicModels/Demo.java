package com.connection_ClassicModels;

import java.sql.Connection;
import java.sql.SQLException;

 
public class Demo {
	public void connectDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		Connection con=Connect_DB.getConnection();
		
		System.out.println(con);
		con.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Demo obj=new Demo();
		obj.connectDatabase();

	}

}
