package com.patternpartner;
import java.sql.*;
import java.util.*;

/**
 * This class facilitates uploading the formatted pattern into the database.
 *
 * @author Sebastian Greenholtz
 */
public class PatternUploader {

    private Pattern pattern;
    private String username;
    private Properties properties;

    /**
     * No argument constructor, asks user for username, password and email
     */
    public PatternUploader() {}

    /**
     * Constructor to initiate with a pattern instance variable and username
     */
    public PatternUploader (PatternPreview previewer, String user) {

        properties = new LoadProperties().loadProperties("patternpartner.properties");
        ArrayList<String> description = previewer.createSectionArrayList(properties.getProperty("description.class"));
        ArrayList<String> materials = previewer.createSectionArrayList(properties.getProperty("materials.class"));
        ArrayList<String> row = previewer.createSectionArrayList(properties.getProperty("rows.class"));

        pattern = previewer.constructPattern(description, materials, row);
        username = user;
    }

    /**
     * Creates SQL statement for Patterns table
     * @return SQL statement to insert data into Patterns table
     */
    public String createPatternsStatement() {
        return "insert into Patterns"
                + " (username, title, description, knitOrCrochet)"
                + " values ('"
                + username + "', " + pattern.getName() + ", "
                + pattern.listToString(pattern.getDescription()) + ", '"
                + pattern.getKnitOrCrochet() + "')";
    }

    /**
     * Creates SQL statement for Patterns table
     * @param patternID patternID from the newly-created item in Patterns table
     * @return ArrayList of SQL statements to insert each row into Patterns table
     */
    public ArrayList<String> createPatternRowsStatement(String patternID) {
        int lineNumber = 0;
        ArrayList<String> statements = new ArrayList<String>();

        while (lineNumber < pattern.getPatternRows().size()) {

            String statement = "insert into PatternRows"
                    + " (patternID, lineID, lineText, isActive, isRepeat)"
                    + " values ("
                    + patternID + ", "
                    + lineNumber + ", \""
                    + pattern.getPatternRows().get(lineNumber).substring(0)
                    + "\", 0, 0)";

            statements.add(statement);
            lineNumber++;
        }

        return statements;
    }

    /**
     * Creates SQL statement for Materials table
     * @param patternID patternID from the newly-created item in Patterns table
     * @return ArrayList of SQL statements to insert each row into materials table
     */
    public ArrayList<String> createMaterialsStatement(String patternID) {
        int lineNumber = 0;
        ArrayList<String> statements = new ArrayList<String>();

        while (lineNumber < pattern.getMaterials().size()) {

            String statement = "insert into Materials"
                    + " (patternID, materialID, material)"
                    + " values ("
                    + patternID + ", "
                    + lineNumber + ", '"
                    + pattern.getMaterials().get(lineNumber)
                    + "')";

            statements.add(statement);
            lineNumber++;
        }
        return statements;
    }

    /**
     * Executes the update for Users, Patterns, Materials and PatternRows
     */
    public void upload() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());
            Statement insertStatement = conn.createStatement();

            // Adds pattern to Patterns table
            insertStatement.executeUpdate(createPatternsStatement());

            // Gets the patternID for the pattern that was just added
            ResultSet patternIDResult = insertStatement.executeQuery("SELECT LAST_INSERT_ID();");
            String patternID = "";
            while (patternIDResult.next()) {
                patternID = patternIDResult.getString("LAST_INSERT_ID()");
            }

            // Uses patternID to create the statements and upload to Pattern Rows table
            for (String statement : createPatternRowsStatement(patternID)) {
                insertStatement.executeUpdate(statement);
            }

            // Uses pattern ID to create the statements and upload to Materials table
            for (String statement : createMaterialsStatement(patternID)) {
                insertStatement.executeUpdate(statement);
            }
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }
}