package com.ehealth.connection;
import java.sql.*;

public class GetConnection {

	private static Connection connection;
	
	public static Connection getConnection() {
		if(connection==null)
		{
			String url = "jdbc:mysql://localhost:3306/workingdb";
			String userName = "root";
			String password = "Vampass123@";
			String driver = "com.mysql.cj.jdbc.Driver";
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, userName, password);
				return connection;
			}
			catch(ClassNotFoundException | SQLException e)
			{
				System.out.println("Class not found");
				e.printStackTrace();
			}
			return null;
		}
		return connection;
	}
}
