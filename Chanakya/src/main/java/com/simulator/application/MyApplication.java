package com.simulator.application;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.apache.log4j.PropertyConfigurator;

import com.simulator.exception.handler.GenericExceptionMapper;
import com.simulator.exception.handler.JsonSyntaxExceptionMapper;
import com.simulator.exception.handler.ValidationExceptionMapper;
import com.simulator.exception.handler.WSExceptionMapper;
import com.simulator.providers.AuthenticationFilter;
import com.simulator.providers.ContentTypeFilter;
import com.simulator.providers.GsonJerseyProvider;
import com.simulator.providers.StatelessCSRFFilter;
import com.simulator.rest.services.UserService;
import com.simulator.util.LogManager;
import com.simulator.utils.ConfigurationLocator;


public class MyApplication extends Application {

	public MyApplication() {
		String log4jConfigFile = ConfigurationLocator.getValue("Config_Location", System.getProperty("user.dir"))+ File.separator + "simulator" + File.separator
				+ "server" + File.separator + "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
		LogManager.debugLog.debug("Log4J Configured");
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		// providers
		s.add(GsonJerseyProvider.class);
		s.add(WSExceptionMapper.class);
		s.add(GenericExceptionMapper.class);
		s.add(ValidationExceptionMapper.class);
		s.add(JsonSyntaxExceptionMapper.class);
		s.add(ContentTypeFilter.class);
		s.add(AuthenticationFilter.class);
		s.add(StatelessCSRFFilter.class);
		
		
		// rest services/controller
		s.add(UserService.class);
		return s;
	}

}
