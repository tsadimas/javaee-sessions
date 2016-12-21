package gr.hua.dit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	private Connection connection;

	public DBConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL+"?useUnicode=true&characterEncoding=utf-8", user, pwd);
	}

	public Connection getConnection() {
		return this.connection;
	}
}
