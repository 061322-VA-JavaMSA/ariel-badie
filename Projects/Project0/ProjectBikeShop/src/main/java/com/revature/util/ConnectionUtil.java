package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection c;

	public static Connection getHardcodedConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/Shop";
		String username = "postgres";
		String password = "";

		// checks if a connection is open else opens a new one and assigns it to c
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}
	
}