package com.simulator.util;

import org.apache.log4j.Logger;

public class LogManager {
	public static final Logger debugLog = Logger.getLogger("debugLogS");
	public static final Logger errorLog = Logger.getLogger("errorLogS");
	public static final Logger jsonLog = Logger.getLogger("jsonLogS");

	private LogManager() {
	}

	public static Logger getLogger(String loggerName) {
		if ("debugLogS".equals(loggerName)) {
			return debugLog;
		} else if ("errorLogS".equals(loggerName)) {
			return errorLog;
		} else if ("jsonLogS".equals(loggerName)) {
			return jsonLog;
		} else {
			return debugLog;
		}
	}
}