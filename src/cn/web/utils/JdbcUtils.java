package cn.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?characterEncoding=UTF-8", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		Connection conn = JdbcUtils.getConnection();
		Connection conn2 = JdbcUtils.getConnection();
		System.out.println(conn);
		System.out.println(conn2);
	}
}
