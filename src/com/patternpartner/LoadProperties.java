package com.patternpartner;

import java.io.*;
import java.util.*;

/**
 * Assists in loading properties from Properties file
 * @author Sebastian Greenholtz
 */
public class LoadProperties {

    /**
     * Loads properties from properties file
     */
    public Properties loadProperties(String propertiesPath) {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesPath));
        }
        catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        }
        catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        return properties;
    }
}
