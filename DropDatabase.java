package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DropDatabase {
	private static final String driver= "com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String user="root";
	private static final String pass="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pass);
			System.out.println("Enter the database name : ");
			String sql="Drop database "+sc.next();
			pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i==0) {
				System.out.println("Deleted Successfully");
			} else {
				System.out.println("Error While deleting");
			}
			pmst.close();
			conn.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
