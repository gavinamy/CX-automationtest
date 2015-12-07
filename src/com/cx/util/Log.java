package com.cx.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

public class Log {
	private static Logger logger;

    private static String filePath = "src/log4j.properties";   
    
    static{
    	 logger = Logger.getLogger("TestProject");
         PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
    }   

    public static void logInfo(Object message) {       
        logger.info("[INFO]" + message);
        Reporter.log(new TimeString().getSimpleDateFormat()+" : "+"[INFO]" + message);
    }

    public static void logError(Object message) {        
        logger.error("[ERROR]" + message);
        Reporter.log(new TimeString().getSimpleDateFormat()+" : "+"[ERROR]" + message);
    }

    public static void logWarn(Object message) {        
        logger.warn("[WARN]" + message);
        Reporter.log(new TimeString().getSimpleDateFormat()+" : "+"[WARN]" + message);
    }
    
    public static void stepInfo(Object message) {       
        logger.info("[STEP]" + message);
        Reporter.log(new TimeString().getSimpleDateFormat()+" : "+"[STEP]" + message);
    }
}
