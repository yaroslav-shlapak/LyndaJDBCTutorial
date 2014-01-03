package com.lynda.javatraining.db.tables;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Tours {

	public static void displayData(ResultSet rs) throws SQLException {
		while (rs.next()) {
			
			StringBuffer buffer = new StringBuffer();
			
			int tourId = rs.getObject("tourId", Integer.class);
			String tourName = rs.getObject("tourName", String.class);
			BigDecimal price = rs.getObject("price", BigDecimal.class);
			
//			int tourId = rs.getInt("tourId");
//			String tourName = rs.getString("tourName");
//			double price = rs.getDouble("price");
			
			buffer.append("Tour " + tourId + ": ");
			buffer.append(tourName);
			
			
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			String formattedPrice = nf.format(price);
			buffer.append(" (" + formattedPrice +")");
			
			System.out.println(buffer.toString());
			
		}
	}
	
}
