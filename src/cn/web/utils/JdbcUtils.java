package cn.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtils {

	static {
		System.out.println("static............");
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void close(Connection connection, Statement pre) {
		try {
			if (pre != null && !pre.isClosed()) {
				pre.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (connection != null && connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) {
		Connection conn = JdbcUtils.getConnection();
		Connection conn2 = JdbcUtils.getConnection();
		System.out.println(conn);
		System.out.println(conn2);
	}
}
