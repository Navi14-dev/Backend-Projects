package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String username="root";
	private static final String password="root";
	private static final String url="jdbc:mysql://localhost:3306/registration";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try {
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("Enter email : ");
			String email=sc.next();
			System.out.println("Enter password : ");
			String password=sc.next();
			String sql="select * from register where email=? and password=?";
			pmst=conn.prepareStatement(sql);
			pmst.setString(1, email);
			pmst.setString(2, password);
			ResultSet rs=pmst.executeQuery();
			if(rs.next()) {
				System.out.println("Successfully Login");
			} else {
			System.out.println("Invalid user");
			}
			conn.close();
			pmst.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
