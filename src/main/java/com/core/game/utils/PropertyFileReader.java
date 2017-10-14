package com.core.game.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyFileReader {

	final static Logger logger = Logger.getLogger(PropertyFileReader.class);

	private static PropertyFileReader propReader = new PropertyFileReader();

	private Properties properties = null;

	private PropertyFileReader() {
		properties = new Properties();
		InputStream istream = null;
		istream = getClass().getClassLoader().getResourceAsStream("Application.properties");
		try {
			properties.load(istream);
		} catch (FileNotFoundException e) {
			logger.error("GamePropertiesError", e);

		} catch (IOException e) {
			logger.error("GamePropertiesError", e);

		} finally {
			try {
				istream.close();
			} catch (Exception e) {
				logger.error("GamePropertiesError", e);
			}
		}

	}

	public static PropertyFileReader getPropFileReader() {
		return propReader;
	}

	public String getValue(String key) {
		return this.properties.getProperty(key);
	}

}
