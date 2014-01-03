package com.lynda.javatraining.db.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.DBType;
import com.lynda.javatraining.db.DBUtil;
import com.lynda.javatraining.db.beans.Admin;

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
				bf.append(rs.getString("userName") +", ");
				bf.append(rs.getString("password"));
				System.out.println(bf.toString());
			}
		} 
	}

	public static Admin getRow(int adminId) throws SQLException {

		String sql = "SELECT * FROM admin WHERE adminId = ?";
		ResultSet rs = null;

		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, adminId);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				Admin bean = new Admin();
				bean.setAdminId(adminId);
				bean.setUserName(rs.getString("userName"));
				bean.setPassword(rs.getString("password"));
				return bean;
			} else {
				System.err.println("No rows were found");
				return null;
			}
			
			
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		} finally {
			if (rs != null) {
				rs.close();
			}
		}


	}

}
