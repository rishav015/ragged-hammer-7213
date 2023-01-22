package com.onlinebanking.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection provideConnection() {
		
		//standard procedure
		
		Connection connect = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url ="jdbc:mysql://localhost:3306/sb101db";
		
		try {
			connect = DriverManager.getConnection(url, "root", "9736043994@Ri");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connect;
		
		
		
		
	}

}
