package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	private final static String URL = "JDBC:mysql://localhost:3306/vehicle";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Joka818714?$";
	private static Connection con;
	private static DBconnection instance;
	
	private DBconnection(Connection con) {
		DBconnection.con = con;
	}
	public static Connection getConnection() throws SQLException {
		   if (instance == null) {
			   try {
				con = DriverManager.getConnection(URL, USERNAME,PASSWORD);
				instance = new DBconnection (con);
			}catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		   return DBconnection.con;
	}
	
}

