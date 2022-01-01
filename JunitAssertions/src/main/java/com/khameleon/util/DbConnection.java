package com.khameleon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "password1");

		return con;
	}
}
