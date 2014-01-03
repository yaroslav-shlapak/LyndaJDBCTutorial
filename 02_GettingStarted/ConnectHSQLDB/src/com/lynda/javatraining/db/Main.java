package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN_STRING =
			"jdbc:mysql://localhost/explorecalifornia";
	
	public static void main(String[] args) throws SQLException {
		
		//Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Connected!");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
	}

}
