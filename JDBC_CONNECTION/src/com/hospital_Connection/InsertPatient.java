package com.hospital_Connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
//3.Insert new record in Patient table using PreparedStatement object.
public class InsertPatient {
	Scanner sc=new Scanner(System.in);
	
	public void insert() {
		try {
			Connection con = ConnectDatabase.getSqlConnection();
			System.out.println("Enter Patient Id:");
			int id=sc.nextInt();
			System.out.println("Enter Patient Name:");
			String name=sc.next();
			System.out.println("Enter Patient Age:");
			int age=sc.nextInt();
			System.out.println("Enter Patient Wieght:");
			int weight=sc.nextInt();
			System.out.println("Enter Patient E-Mail:");
			String mail=sc.next();
			//System.out.println("Enter Admission Date ");
			 
			String sql = "insert into patient values(?,?,?,?,?,?)";
			PreparedStatement stat = con.prepareCall(sql);
			stat.setInt(1, id);
			stat.setString(2, name);
			stat.setInt(3, age);
			stat.setDouble(4, weight);
			stat.setString(5, mail);
			stat.setDate(6, Date.valueOf("2023-10-10"));
			//stat.setDate(6, System.currentTimeMillis());

			int cnt = stat.executeUpdate();
			System.out.println(cnt + " Row Successfully Inserted 👍👍");
			
			con.close();
			stat.close();
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
		InsertPatient obj=new InsertPatient();
		obj.insert();

	}

}
