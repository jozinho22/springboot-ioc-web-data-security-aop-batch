package com.douineau.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties getProperties(String path) throws IOException {
		
		Properties prop = new Properties();
		try {
			InputStream stream = ConfigReader.class.getResourceAsStream(path);

			prop.load(stream);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return prop;
	}
}
