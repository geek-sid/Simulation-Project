package com.simulator.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

public class ConfigurationLocator {
	private static Properties config = new Properties();
	private static ConfigurationLocator instance=new ConfigurationLocator();
	private static final String CONFIG_FILE_NAME = "Sim_Configurations.xml";

	private ConfigurationLocator() {
		try {
			loadProperty();
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger("sim").log(Level.ALL, "hello", ex);
		}
	}

	public static ConfigurationLocator getInstance(){
		return instance;
	}
	public static Properties getConfig() {
		return config;
	}

	public static String getValue(String key, String defaultValue) {
		if (config != null && config.containsKey(key)) {
			return config.getProperty(key, defaultValue);
		}
		return defaultValue;
	}

	private void loadProperty() throws IOException, URISyntaxException {

		String jarPath = getJarFilePath();
		Document document = null;
		Element rootElement = null;
		config = new Properties();
		try {
			Builder patchBuilder = new Builder();
			String filePath = jarPath + File.separator + CONFIG_FILE_NAME;
			File f1 = new File(filePath);
			document = patchBuilder.build(f1);
			rootElement = document.getRootElement();

			Elements locations = rootElement.getChildElements("Location");
			for (int count = 0; count < locations.size(); count++) {
				Element location = locations.get(count);
				String name = location.getFirstChildElement("Name").getValue();
				String path = location.getFirstChildElement("Path").getValue();
				config.setProperty(name, path);
			}

		} catch (ValidityException e) {
			e.printStackTrace();
		} catch (ParsingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
	}

	private static String getJarFilePath() throws URISyntaxException, UnsupportedEncodingException {
		// CodeSource codeSource =
		// ConfigurationLocator.class.getProtectionDomain().getCodeSource();

		File jarFile;

		// if (codeSource.getLocation() != null) {
		// jarFile = new File(codeSource.getLocation().toURI());
		// } else {
		String path = ConfigurationLocator.class.getResource(ConfigurationLocator.class.getSimpleName() + ".class")
				.getPath();
		String jarFilePath = path.substring(path.indexOf(":") + 1, path.indexOf("!"));
		jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
		jarFile = new File(jarFilePath);
		// }
		return jarFile.getParentFile().getAbsolutePath();
	}

}
