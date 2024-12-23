package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/registration";
	private static final String user="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("Enter table name :");
			String sql="update "+sc.next()+" set name=?,email=?,password=? where id=?";
			pmst=conn.prepareStatement(sql);
			
			System.out.println("Enter the name :");
			pmst.setString(1, sc.next());
			System.out.println("Enter the email :");
			pmst.setString(2, sc.next());
			System.out.println("Enter the password :");
			pmst.setString(3, sc.next());
			System.out.println("Provide the id :");
			pmst.setInt(4, sc.nextInt());
			int i=pmst.executeUpdate();
			if(i > 0) {
				System.out.println("Updated Successfully");
			} else {
				System.out.println("Error . please check");
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
