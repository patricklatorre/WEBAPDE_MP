package db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBPool {
	public static String schema = "webapde_db";
	public static String username = "root";
	public static String password = "";
	public static String url = "jdbc:mysql://localhost:3306/";
	public static String driver = "com.mysql.jdbc.Driver";
	
	private static DBPool singleton = null;
	
	private static BasicDataSource basicDataSource;
	
	private DBPool() {
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setUrl(url + schema);
	}

	public static DBPool getInstance() {
		if(singleton == null) {
			singleton = new DBPool();
		}
		return singleton;
	}

	public Connection getConnection(){
		try {
			return basicDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
}
