package com.redhat.claro.engine.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public final class Configuration extends HashMap<String, String> {

	private static final long serialVersionUID = -7425339074031363161L;
	private static Configuration config;
	private static Logger logger = Logger.getLogger(Configuration.class);

	public static Configuration instance() {

		if (config == null) config = new Configuration();
		return config;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	private Configuration() {

	}

}
