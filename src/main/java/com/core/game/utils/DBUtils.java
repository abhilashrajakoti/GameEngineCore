package com.core.game.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:/home/abhilash/Documents/CricketGame";
			conn=DriverManager.getConnection(url);
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
	}
	

}
