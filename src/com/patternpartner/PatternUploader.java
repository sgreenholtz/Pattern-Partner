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
                + " (username, title, description, materials, knitOrCrochet)"
                + " values ('"
                + username + "', '" + pattern.getName() + "', '"
                + pattern.listToString(pattern.getDescription()) + "', '"
                + pattern.listToString(pattern.getMaterials()) + "', '"
                + pattern.getKnitOrCrochet() + "')";
    }

    /**
     * Creates SQL statement for Patterns table
     * @param patternID patternID from the newly-created item in Patterns table
     * @return ArrayList of SQL statements to insert each row into Patterns table
     */
    public ArrayList<String> createPatternRowsStatement(String patternID) {
        String table = "CrochetPatternRows";
        int lineNumber = 0;
        ArrayList<String> statements = new ArrayList<String>();

        if (pattern.getKnitOrCrochet().equals("k")) {
            table = "KnitPatternRows";
        }

        while (lineNumber < pattern.getPatternRows().size()) {

            String statement = "insert into " + table
                    + " (patternID, lineID, lineText, isActive, isRepeat)"
                    + " values ("
                    + patternID + ", "
                    + lineNumber + ", \""
                    + pattern.getPatternRows().get(lineNumber).substring(1)
                    + "\", 0, 0)";

            statements.add(statement);
            lineNumber++;
        }

        return statements;
    }

    /**
     * Executes the update for Users, Patterns, and PatternRows, with a printed success
     * statement for each.
     */
    public void upload() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());

            Statement insertStatement = conn.createStatement();
            insertStatement.executeUpdate(createPatternsStatement()); // error here
            System.out.println("Patterns insert successful.");

            ResultSet patternIDResult = insertStatement.executeQuery("SELECT LAST_INSERT_ID();");
            String patternID = "";
            while (patternIDResult.next()) {
                patternID = patternIDResult.getString("LAST_INSERT_ID()");
            }

            int lineCounter = 0;
            for (String statement : createPatternRowsStatement(patternID)) {
                insertStatement.executeUpdate(statement);
                System.out.println("Line " + lineCounter + "insert successful.");
                lineCounter++;
            }
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }
}