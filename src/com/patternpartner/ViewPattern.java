package com.patternpartner;

import java.util.*;
import java.sql.*;

/**
 * Allows user to view a pattern once it is uploaded to the database or view a description of all patterns uploaded
 * into the database for a specified user.
 * @author Sebastian Greenholtz
 */
public class ViewPattern {

    private String username;
    private Properties properties;

    /**
     * Empty constructor
     */
    public ViewPattern() {}

    /**
     * Constructor to set instance variables
     */
    public ViewPattern(String username) {
        this.username = username;
        properties = new LoadProperties().loadProperties("patternpartner.properties");
    }

    /**
     * Getter for properties
     * @return properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Selects all pattern titles from the database for a specified user
     * @return Map where the patternID is mapped to the title
     */
    public Map<Integer, String> getAllPatternTitles() {
        Map<Integer, String> titles = new HashMap<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user"), properties.getProperty("db.password"));

            Statement selectStatement = conn.createStatement();

            String selectSQL = "select patternID, title from Patterns where username='" + username + "'";
//            System.out.println(selectSQL);
            ResultSet patternsResult = selectStatement.executeQuery(selectSQL);

            while (patternsResult.next()) {
                titles.put(patternsResult.getInt("patternID"), patternsResult.getString("title"));
            }
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return titles;
    }

    /**
     * Selects all patterns from database for specified user and returns a Map with the patternID of the pattern
     * and the letter "k" or "c" designating if they are knit or crochet patterns
     * @return map with patternID mapped to whether the pattern is a knit pattern or crochet pattern
     */
    public Map<Integer, String> getKnitOrCrochet() {
        Map<Integer, String> titles = new HashMap<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user"), properties.getProperty("db.password"));

            Statement selectStatement = conn.createStatement();

            String selectSQL = "select patternID, knitOrCrochet from Patterns where username='" + username + "'";

            ResultSet patternsResult = selectStatement.executeQuery(selectSQL);

            while (patternsResult.next()) {
                titles.put(patternsResult.getInt("patternID"), patternsResult.getString("knitOrCrochet"));
            }
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return titles;
    }

    public static void main(String[] args) {
        ViewPattern patternTest = new ViewPattern("skolya");
        System.out.println(patternTest.getAllPatternTitles());
    }


}
