package com.patternpartner.utilities;
/**
 * Logging singleton
 * @author Sebastian Greenholtz
 */
public final class Logger {

    private static Logger instance = null;
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

    private Logger() {}

    public static void info(String message) {
        getLogger().info(message);
    }

    public static void error(String message) {
        getLogger().error(message);
    }

    public static void error(Exception e) {
        getLogger().error(e.getMessage() + e.getStackTrace());
    }

    private static org.apache.log4j.Logger getLogger() {
        if (instance == null) {
            instance = new Logger();
        }
        return logger;
    }
}
