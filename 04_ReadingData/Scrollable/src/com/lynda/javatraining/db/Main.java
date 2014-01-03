package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lynda.javatraining.db.tables.States;

public class Main {

	public static void main(String[] args) throws Exception {

		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
				Statement stmt = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(
						"SELECT stateId, stateName FROM states");   	
				) {
			States.displayData(rs);
			
			rs.last();
			System.out.println("Number of rows: " + rs.getRow());
			System.out.println("The last state is " + rs.getString("stateName"));
			rs.first();
			System.out.println("The first state is " + rs.getString("stateName"));
			
			rs.absolute(10);
			System.out.println("The 10th state is " + rs.getString("stateName"));
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
