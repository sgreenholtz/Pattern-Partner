package com.patternpartner;
import java.sql.*;
import java.util.*;

/**
 * This class facilitates uploading the formatted pattern into the database
 * @author Sebastian Greenholtz
 */
public class PatternUploader {

    static String DB_URL = "jdbc:mysql://localhost:3306/PatternPartner";
    static String USERNAME = "root";
    static String PASSWORD = "student";

    private Pattern pattern;
    private String username;
    private String password;
    private String email;

    /**
     * No argument constructor, asks user for username, password and email
     */
    public PatternUploader() {
        CMDHelper helper = new CMDHelper();
        username = helper.getUserInput("Username: ");
        password = helper.getUserInput("Password: ");
        email = helper.getUserInput("Email: ");
    }

    /**
     * Constructor to initiate with a pattern instance variable
     */
    public PatternUploader (Pattern newPattern) {
        pattern = newPattern;
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
     * Creates SQL statement for users table
     * @return SQL statement to insert data into Users table
     */
    public String createUsersStatement() {
        return "insert into Users"
                + " (username, password, email)"
                + " values (" + username + ", 'SHA1(" + password + ")', " + email + ")";
    }

    /**
     * Creates SQL statement for Patterns table
     * @return SQL statement to insert data into Patterns table
     */
    public String createPatternsStatement() {
        return "insert into Patterns"
                + " (username, title, description, materials)"
                + " values ("
                + username + ", " + pattern.getName() + ", "
                + pattern.listToString(pattern.getDescription()) + ", "
                + pattern.listToString(pattern.getMaterials()) + ")";
    }

    /**
     * Creates SQL statement for Patterns table
     * @return ArrayList of SQL statements to insert each row into Patterns table
     */
    public ArrayList<String> createPatternRowsStatement() {
        String table = "CrochetPatternRows";
        String patternID = "";
        int lineNumber = 0;
        ArrayList<String> statements = new ArrayList<String>();

        if (pattern.getKnitOrCrochet().equals("k")) {
            table = "KnitPatternRows";
        }

        try {
            Statement getPatternID = makeConnection().createStatement();
            ResultSet patternIDResult = getPatternID.executeQuery("SELECT LAST_INSERT_ID();");
            while (patternIDResult.next()) {
                patternID = patternIDResult.getString("LAST_INSERT_ID()");
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        while (lineNumber < pattern.getPatternRows().size()) {

            String statement = "insert into " + table
                    + " (patternID, lineID, lineText, isActive, isRepeat)"
                    + " values ("
                    + patternID + ", "
                    + lineNumber + ", "
                    + pattern.getPatternRows().get(lineNumber)
                    + ", 0, 0)";

            statements.add(statement);
            lineNumber++;
        }

        return statements;
    }

    /**
     * Prints the statements on the command line for verification
     */
    public void viewStatements() {
        System.out.println(createUsersStatement() + System.lineSeparator());
        System.out.println(createPatternsStatement() + System.lineSeparator());
        System.out.println(createPatternRowsStatement() + System.lineSeparator());
    }

}
