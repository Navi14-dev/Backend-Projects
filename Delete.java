package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete {
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
			System.out.println("Enter table name : ");
			String sql="delete from "+sc.next()+" where id = ?";
			pmst=conn.prepareStatement(sql);
			System.out.println("Enter id : ");
			pmst.setInt(1, sc.nextInt());
			
			int i=pmst.executeUpdate();
			if(i == 0) {
				System.out.println("Data is deleted successfully ");
			} else {
				System.out.println("Error ! please check");
			}
			conn.close();
			pmst.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
