package br.com.barcadero.commons.loggin;

import java.io.File;
import java.util.Date;

import org.apache.log4j.Logger;

import br.com.barcadero.commons.util.HandleDateHour;

public class LoggerFile {
	
	public static final String LOG_FOR_SAT = "logSAT-" + getDate();
	static{
		System.out.println("Loading log API");
		System.setProperty("logFile", System.getProperty("user.dir") + File.separator + "logs" + File.separator);
	}
	
	private static Logger getInstance(Class<?> classForLog) {
		Logger log = Logger.getLogger(classForLog);
		return log;
	}
	
	public static Logger getLogForSAT(Class<?> classForLog) {
		System.setProperty("logging", LOG_FOR_SAT);
		return getInstance(classForLog);
	}
	
	public static String getDate() {
		return new HandleDateHour().format(new Date(), "yyyyMMdd");
	}

}
