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
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());

            Statement selectStatement = conn.createStatement();

            String selectSQL = "select patternID, title from Patterns where username='" + username + "'";
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
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());
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

    /**
     * Gets the components of a pattern based on the ID and returns a Pattern object
     * @param patternID ID for the pattern to load
     * @return pattern object
     */
    public Pattern getPattern(Integer patternID) {
        Pattern pat = null;
        ArrayList<String> patternRowsList = new ArrayList<String>();
        ArrayList<String> materialsList = new ArrayList<String>();
        ArrayList<Boolean> isActive = new ArrayList<Boolean>();
        String name = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());
            Statement selectStatement = conn.createStatement();

            String patternRows = "select lineText, isActive from PatternRows where patternID='" + patternID + "'";
            ResultSet patternRowsResult = selectStatement.executeQuery(patternRows);

            while (patternRowsResult.next()) {
                patternRowsList.add(patternRowsResult.getString("lineText"));
                if (patternRowsResult.getInt("isActive") == 0) {
                    isActive.add(false);
                } else {
                    isActive.add(true);
                }
            }

            String materials = "select material from Materials where patternID='" + patternID + "'";
            ResultSet materialsResult = selectStatement.executeQuery(materials);

            while (materialsResult.next()) {
                materialsList.add(materialsResult.getString("material"));
            }

            String description = "select title, description "
                                + "from Patterns where patternID='" + patternID + "'";
            ResultSet descriptionResult = selectStatement.executeQuery(description);

            while (descriptionResult.next()) {
                pat = new Pattern(descriptionResult.getString("title"),
                        descriptionResult.getString("description"),
                        materialsList,
                        patternRowsList,
                        isActive);
            }
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return pat;
    }

}
