package com.simulator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ServerCongifUtil {

	private static Properties props = null;
	private static ServerCongifUtil instance=new ServerCongifUtil();
	private static Properties dbProps = null;
	private static ServerCongifUtil dbInstance=new ServerCongifUtil();
	private ServerCongifUtil(){
		try {
			loadConfig();
			loadDBProperties();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ServerCongifUtil getDBInstance(){
		return dbInstance;
	}
	public static Properties getDBConfig() {
		return dbProps;
	}

	
	public static ServerCongifUtil getInstance(){
		return instance;
	}
	public static Properties getConfig() {
		return props;
	}
	
	public static String getDBValue(String key, String defaultValue) {
		if (dbProps != null && dbProps.containsKey(key)) {
			return dbProps.getProperty(key, defaultValue);
		}
		return defaultValue;
	}

	public static String getValue(String key, String defaultValue) {
		if (props != null && props.containsKey(key)) {
			return props.getProperty(key, defaultValue);
		}
		return defaultValue;
	}

	public static Properties loadConfig() throws IOException {
		if (props == null) {
			props = new Properties();
			String serverPropertiesPath =ConfigurationLocator.getValue("Config_Location", System.getProperty("user.dir")) + File.separator + "simulator" + File.separator
					+ "config.ini";
			FileInputStream is = new FileInputStream(serverPropertiesPath);
			props.load(is);
		}
		return props;
	}
	
	public static Properties loadDBProperties() throws IOException {
		String dbPropertiesPath = ConfigurationLocator.getValue("Config_Location", System.getProperty("user.dir"))
				+ File.separator + "simulator" + File.separator + "server" + File.separator + "db" + File.separator + "database1.properties";
		  FileReader reader=new FileReader(dbPropertiesPath);  
	      
		  dbProps=new Properties();  
		  dbProps.load(reader);  
		      
//		    System.out.println(p.getProperty("user"));  
//		    System.out.println(p.getProperty("password"));
			return dbProps;
	}
}
