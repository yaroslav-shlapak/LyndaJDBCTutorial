package com.lynda.javatraining.db.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.ConnectionManager;

public class StatesManager {

	private static Connection conn = ConnectionManager.getInstance().getConnection();
	
	public static void displayAllRows() throws SQLException {

		String sql = "SELECT adminId, userName, password FROM admin";
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			while(rs.next()) {
				String stateFullName =
						rs.getString("stateId") + ": " + rs.getString("stateName");
				System.out.println(stateFullName);
			}

		}
	}
}