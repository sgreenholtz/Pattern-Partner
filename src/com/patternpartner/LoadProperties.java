package com.patternpartner;

import java.io.*;
import java.util.*;

/**
 * Assists in loading properties from Properties file
 * @author Sebastian Greenholtz
 */
public class LoadProperties {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    /**
     * Loads properties from properties file
     *
     * @param propertiesPath String path to the properties file
     * @return Properties object with the loaded file
     */
    public Properties loadProperties(String propertiesPath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesPath));
        } catch (IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        return properties;
    }

    @Override
    public String toString() {
        String output = "";
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String name : propertyNames) {
            output += name + System.lineSeparator();
        }
        return output;
    }
}