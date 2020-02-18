package com.core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * 提供一些基础api
 * 
 * @author jin wei
 *
 */
public class Common {

	private static final Logger LOG = LogManager.getLogger(Common.class);
	
	public static String setTestConfigFromPropertyFile() {
		Properties prop = new Properties();
		InputStream in;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			in = loader.getResourceAsStream("testConfig.properties");
			prop.load(in);
		} catch (FileNotFoundException e) {
			LOG.error("Cannot find the testConfig.properties file under project root folder, please check manually");
			e.printStackTrace();
		} catch (IOException e) {
			LOG.error("Cannot read the testConfig.properties file under project root folder");
			e.printStackTrace();
		}
		return prop.getProperty("env", "beta").trim();
	}
}
