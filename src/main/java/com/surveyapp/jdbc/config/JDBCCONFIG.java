package com.surveyapp.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCCONFIG {
	
	private static final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sydemo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345";

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName(CLASSNAME);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;

	}


}
