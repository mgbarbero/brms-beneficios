package com.redhat.claro.engine.config;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

public final class Configuration {

	private static org.apache.commons.configuration.Configuration config;
	private static Logger logger = Logger.getLogger(Configuration.class);

	public static org.apache.commons.configuration.Configuration instance() {

		if (config == null) {
			try {
				File file = new File(System.getProperty("property.file"));
				config = new PropertiesConfiguration(file);
			} catch (ConfigurationException e) {
				logger.error(e);
			}
		}
		return config;
	}

	private Configuration() {

	}

}
