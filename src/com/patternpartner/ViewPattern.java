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
     * Selects all pattern titles from the database for a specified user
     * @return an ArrayList where the patternID is mapped to the title
     */
    public Map<Integer, String> getAllPatternTitles() {
        Map<Integer, String> titles = new HashMap<>();
        try {
            Connection conn = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user"), properties.getProperty("db.password"));

            Statement selectStatement = conn.createStatement();

            String selectSQL = "select patternID, title from Patterns" +
                                "where username='" + username + "'";

            ResultSet patternsResult = selectStatement.executeQuery(selectSQL);

            while (patternsResult.next()) {
                titles.put(patternsResult.getInt("patternID"), patternsResult.getString("title"));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return titles;
    }


}
