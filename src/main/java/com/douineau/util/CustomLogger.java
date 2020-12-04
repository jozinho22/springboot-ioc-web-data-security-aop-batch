package com.douineau.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {
	  
    public static Logger getBasicLogger() {
        return LoggerFactory.getLogger(CustomLogger.class);
    }
    
    public static Logger getCustomLogger() {
        return LoggerFactory.getLogger("customLogger");
    }

}
