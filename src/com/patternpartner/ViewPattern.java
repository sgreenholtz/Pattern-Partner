package com.patternpartner;

import java.util.*;
import java.util.Map.*;
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
     * Creates a connection with the database
     * @return Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        ConfigureEnvVars vars = new ConfigureEnvVars();
        return DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());
    }

    /**
     * Selects all pattern titles from the database for a specified user
     * @return Map where the patternID is mapped to the title and description
     */
    public Map<Integer, String> getAllPatternTitles() {
        Map<Integer, String> titles = new HashMap<>();
        try {
            Connection conn = getConnection();
            String sql = "SELECT patternID, title "
                    + "FROM Patterns "
                    + "WHERE username = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                titles.put(results.getInt("patternID"), results.getString("title"));
            }
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return titles;
    }

    /**
     * Selects all descriptions from the patterns for a specified user
     * @return Map of patternID, description
     */
    public Map<Integer, String> getAllDescriptions() {
        Map<Integer, String> descriptions = new HashMap<>();
        try {
            Connection conn = getConnection();
            String sql = "SELECT patternID, description "
                    + "FROM Patterns "
                    + "WHERE username = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                descriptions.put(results.getInt("patternID"), results.getString("description"));
            }
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return descriptions;
    }

    /**
     * Creates a map where the patternID is mapped to an array list with the first
     * item as the title and the second item as the description. Due to the length,
     * only the first 140 characters of a description is saved in this view
     * @return Map of patternID mapped to Array list of title and description
     */
    public Map<Integer, ArrayList<String>> getTitlesAndDescriptions() {
        Map<Integer, ArrayList<String>> finalMap = new HashMap<>();
        Map<Integer, String> titles = getAllPatternTitles();
        Map<Integer, String> descriptions = getAllDescriptions();

        for (Entry<Integer, String> entry : titles.entrySet()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(entry.getValue());
            if (descriptions.get(entry.getKey()).length() > 140) {
                list.add(descriptions.get(entry.getKey()).substring(0, 139));
            } else {
                list.add(descriptions.get(entry.getKey()));
            }
            finalMap.put(entry.getKey(), list);
        }

        return finalMap;
    }


    /**
     * Selects all patterns from database for specified user and returns a Map with the patternID of the pattern
     * and the letter "k" or "c" designating if they are knit or crochet patterns
     * @return map with patternID mapped to whether the pattern is a knit pattern or crochet pattern
     */
    public Map<Integer, String> getKnitOrCrochet() {
        Map<Integer, String> titles = new HashMap<>();
        try {
            Connection conn = getConnection();
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
            Connection conn = getConnection();
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
