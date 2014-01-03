package com.lynda.javatraining.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.lynda.javatraining.db.tables.Tours;
import com.lynda.javatraining.util.InputHelper;

public class Main {

	private static final String SQL = "{call GetToursWithCountByPrice(?, ?)}";

	public static void main(String[] args) throws Exception {

		double maxPrice;
		try {
			maxPrice = InputHelper.getDoubleInput("Enter a maximum price: ");
		} catch (NumberFormatException e) {
			System.err.println("Error: invalid number");
			return;
		}
		
		ResultSet rs = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				CallableStatement stmt = conn.prepareCall(
						SQL,
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
				) {
			stmt.setDouble(1, maxPrice);
			stmt.registerOutParameter("total", Types.INTEGER);
			rs = stmt.executeQuery();
			
			int nRows = stmt.getInt("total");
			
			Tours.displayData(rs, nRows);

		} catch (SQLException e) {
			System.err.println(e);
		}
		finally {
			if (rs != null) rs.close();
		}
	}

}
