package com.lynda.javatraining.db.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.DBType;
import com.lynda.javatraining.db.DBUtil;

public class AdminManager {

	public static void displayAllRows() throws SQLException {
		
		String sql = "SELECT adminId, userName, password FROM admin";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){

			System.out.println("Admin Table:");
			while (rs.next()) {
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getInt("adminId") + ": ");
				bf.append(rs.getString("userName"));
				System.out.println(bf.toString());
			}
		}
	}
}
