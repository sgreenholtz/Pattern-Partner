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

    /**
     * Makes a connection with the PatternPartner database
     * @return conn Active connection
     */
    public Connection makeConnection() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            return conn;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

}
