package com.lynda.javatraining.db;

import java.sql.SQLException;

import com.lynda.javatraining.db.tables.AdminManager;

public class Main {

	public static void main(String[] args) throws SQLException {

		AdminManager.displayAllRows();
		
	}

}
