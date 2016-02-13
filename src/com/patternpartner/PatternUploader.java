package com.patternpartner;
import java.sql.*;

/**
 * This class facilitates uploading the formatted pattern into the database
 * @author Sebastian Greenholtz
 */
public class PatternUploader {

    static String DB_URL = "jdbc:mysql://localhost:3306/PatternPartner";
    static String USERNAME = "root";
    static String PASSWORD = "student";

    private NewPattern pattern;

    /**
     * No argument constructor
     */
    public PatternUploader() {}

    /**
     * Constructor to initiate with a pattern instance variable
     */
    public PatternUploader (NewPattern newPattern) {
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
     *
     */

}
