package com.core.game.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DBUtils {
	final static Logger logger = Logger.getLogger(DBUtils.class);

	public static Connection getConnection() {
		Connection conn = null;
		try {
			String jdbcDriver=PropertyFileReader.getPropFileReader().getValue("DB.JDBCDRIVER");
			String dburl=PropertyFileReader.getPropFileReader().getValue("DB.URL");
			Class.forName(jdbcDriver);
			String url = dburl;
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			logger.error("GameEngineDB", e);
		} catch (ClassNotFoundException e) {
			logger.error("GameEngineDB", e);
		}
		return conn;
	}

}
