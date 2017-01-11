package hsbc.common.logger;

import org.apache.log4j.Logger;

public class CommonLogger {
	public static void debug(Object caller, String logMessage) {
		//Logger logger = LoggerFactory.getLogger(caller.getClass());
		Logger logger = Logger.getLogger(caller.getClass());
		ApplicationLogMessage appLogMessage = new ApplicationLogMessage(caller.getClass().getName(), logMessage);
		logger.debug(appLogMessage.toString());
	}

	public static void info(Object caller, String logMessage) {
		//Logger logger = LoggerFactory.getLogger(caller.getClass());
		Logger logger = Logger.getLogger(caller.getClass());
		ApplicationLogMessage appLogMessage = new ApplicationLogMessage(caller.getClass().getName(), logMessage);
		logger.info(appLogMessage.toString());
	}

	public static void warn(Object caller, String logMessage) {
		//Logger logger = LoggerFactory.getLogger(caller.getClass());
		Logger logger = Logger.getLogger(caller.getClass());
		ApplicationLogMessage appLogMessage = new ApplicationLogMessage(caller.getClass().getName(), logMessage);
		logger.warn(appLogMessage.toString());
	}

	public static void error(Object caller, String logMessage) {
		//Logger logger = LoggerFactory.getLogger(caller.getClass());
		Logger logger = Logger.getLogger(caller.getClass());
		ApplicationLogMessage appLogMessage = new ApplicationLogMessage(caller.getClass().getName(), logMessage);
		logger.error(appLogMessage.toString());
	}

}
