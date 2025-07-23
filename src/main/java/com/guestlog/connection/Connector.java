package com.guestlog.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static Connection getConnection() {
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/guestlog";
		String user="root";
		String pwd="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
//	public static void main(String[] args) {
//		Connection con=getConnection();
//		System.out.println("Connection established");
//	}
}
