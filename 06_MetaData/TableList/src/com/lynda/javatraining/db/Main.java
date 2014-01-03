package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception {

		Connection conn = ConnectionManager.getInstance().getConnection();
		ResultSet rsTables = null;
		
		
		try  {
			DatabaseMetaData metadata = conn.getMetaData();
			String[] tableTypes = {"TABLE"};
			rsTables = metadata.getTables(null, "%", "%", tableTypes);
			while(rsTables.next()) {
				System.out.println(rsTables.getString("TABLE_NAME"));
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		finally {
			if(rsTables != null)
				rsTables.close();
			
		}
		
		ConnectionManager.getInstance().close();
		
	}

}
