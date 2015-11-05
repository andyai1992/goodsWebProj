package com.goods.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	public static Connection getConnection() {
		Connection connection = threadLocal.get();
		if (connection == null) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
				threadLocal.set(connection);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return connection;
	}

	public static void closeConnection() {
		Connection connection = threadLocal.get();
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		threadLocal.set(null);
	}
}
