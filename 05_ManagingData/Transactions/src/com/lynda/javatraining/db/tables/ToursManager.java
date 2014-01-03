package com.lynda.javatraining.db.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

import com.lynda.javatraining.db.ConnectionManager;

public class ToursManager {

	private static Connection conn = ConnectionManager.getInstance().getConnection();

	public static void displayAllRows() throws SQLException {

		String sql = "SELECT adminId, userName, password FROM admin";
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
			while (rs.next()) {
				StringBuffer buffer = new StringBuffer();

				buffer.append("Tour " + rs.getInt("tourId") + ": ");
				buffer.append(rs.getString("tourName"));

				double price = rs.getDouble("price");
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				String formattedPrice = nf.format(price);
				buffer.append(" (" + formattedPrice +")");

				System.out.println(buffer.toString());
			}
		}
	}
}
