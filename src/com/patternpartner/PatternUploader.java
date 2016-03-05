package com.patternpartner;
import java.sql.*;
import java.util.*;

/**
 * This class facilitates uploading the formatted pattern into the database.
 * <p>
 * Root User: admin3pE2m2s <br />
 * Root Password: tl3k5QXfsPNl <br />
 * Database Name: patternpartner <br />
 * Connection URL: mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/
 * </p>
 * @author Sebastian Greenholtz
 */
public class PatternUploader {

    static String DB_URL = "jdbc:mysql://localhost:3306/PatternPartner?useSSL=false";
    static String USERNAME = "root";
    static String PASSWORD = "student";

    private Pattern pattern;
    private String username;

    /**
     * No argument constructor, asks user for username, password and email
     */
    public PatternUploader() {}

    /**
     * Constructor to initiate with a pattern instance variable and username
     */
    public PatternUploader (PatternPreview previewer, String user) {
        ArrayList<String> description = previewer.createSectionArrayList("success");
        ArrayList<String> materials = previewer.createSectionArrayList("info");
        ArrayList<String> row = previewer.createSectionArrayList("warning");

        pattern = previewer.constructPattern(description, materials, row);
        username = user;
    }

    /**
     * Makes a connection with the PatternPartner database
     * @return conn Active connection
     */
    public Connection makeConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            return conn;
        }
    }

    /**
     * Creates SQL statement for Patterns table
     * @return SQL statement to insert data into Patterns table
     */
    public String createPatternsStatement() {
        return "insert into Patterns"
                + " (username, title, description, materials)"
                + " values ('"
                + username + "', " + pattern.getName() + ", "
                + pattern.listToString(pattern.getDescription()) + ", "
                + pattern.listToString(pattern.getMaterials()) + ")";
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
     * Prints the statements on the command line for verification.
     * Note: PatternID is created dynamically as the pattern is inserted into the database, so
     * this value is represented in this method by the string ID.
     */
    public void viewStatements() {
//        System.out.println(createUsersStatement() + ";" + System.lineSeparator());
        System.out.println(createPatternsStatement() + ";" + System.lineSeparator());
        for (String statement : createPatternRowsStatement("ID")) {
            System.out.println(statement + ";" + System.lineSeparator());
        }
    }

    /**
     * Executes the update for Users, Patterns, and PatternRows, with a printed success
     * statement for each.
     */
    public void upload() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement insertStatement = conn.createStatement();
            insertStatement.executeUpdate(createPatternsStatement());
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
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }


}
