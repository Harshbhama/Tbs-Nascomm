package com.Tbs.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFactory {

	Connection connection;

	public Connection setMysqlConnection() {

		try {
			com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tbs2", "root", "");
			connection.setAutoCommit(false);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return connection;
	}

	public void closeMysqlConnection() {

		try {
			connection.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

	}

}
