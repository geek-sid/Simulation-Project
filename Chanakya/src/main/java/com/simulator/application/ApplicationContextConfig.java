package com.simulator.application;

import java.io.File;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.FileSystemResource;

import com.simulator.utils.ConfigurationLocator;

@Import(RepositoryConfig.class)
@Configuration
public class ApplicationContextConfig {
	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {

		String configLocation = ConfigurationLocator.getValue("Config_Location", System.getProperty("user.dir"))
				+ File.separator + "simulator" + File.separator + "server" + File.separator + "db";

		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocations(new FileSystemResource(configLocation + File.separator + "database.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}

}
