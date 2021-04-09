package com.amazone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

	static Connection connection;
	public static Connection openConnection() {
		try {
//			String sql = "CREATE TABLE userdetails (userId varchar(20) primary key, name varchar(20), password varchar(20), mailid varchar(20),"
//					      +"mobileno integer NOT NULL, address varchar(20), wallet decimal)";
			
//			String sql2 = "CREATE TABLE products (name varchar(20), productid integer PRIMARY KEY,"
//				      +"brand varchar(20), category varchar(20) NOT NULL, price decimal)";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "system";
			String password = "password";
			connection = DriverManager.getConnection(url,username,password);
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.execute();
//			statement.close();
			
//			PreparedStatement statement = connection.prepareStatement(sql2);
//			statement.execute();
//			System.out.println("Created " + !statement.execute());
//			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}	
		public static void closeConnection() {
			if(connection!=null)
				try {
					connection.close();
				}catch(SQLException e) {
				e.printStackTrace();
				}
			System.out.println("Connection Closed");
		}
	
}
