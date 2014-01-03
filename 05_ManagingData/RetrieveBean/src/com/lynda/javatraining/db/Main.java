package com.lynda.javatraining.db;

import java.sql.SQLException;

import com.lynda.javatraining.db.beans.Admin;
import com.lynda.javatraining.db.tables.AdminManager;
import com.lynda.javatraining.util.InputHelper;

public class Main {

	public static void main(String[] args) throws SQLException {

		AdminManager.displayAllRows();
		
		int adminId = InputHelper.getIntegerInput("Select a row: ");
		
		Admin bean = AdminManager.getRow(adminId);
		
		if (bean == null)
			System.err.println("No rows were found");
		else {
			System.out.println("Admin id: " + bean.getAdminId());
			System.out.println("User name: " + bean.getUserName());
			System.out.println("Password: " + bean.getPassword());
		}
			
		
	}

}
