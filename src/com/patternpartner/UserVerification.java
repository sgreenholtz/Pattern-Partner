package com.patternpartner;
import java.sql.*;

/**
 * This class logs in the user and checks database for existing user or new user
 * @author Sebastian Greenholtz
 */
public class UserVerification {
    static String DB_URL = "jdbc:mysql://localhost:3306/PatternPartner";
    static String USERNAME = "root";
    static String PASSWORD = "student";

    private String username;
    private String password;

    /**
     * Empty constructor
     */
    public UserVerification() {}

    /**
     * Constructor uses username and password from the table to
     * set instance variables
     */
    public UserVerification(String user, String pass) {
        username = user;
        password = pass;
    }

    /**
     * Gets value of username
     * @return value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Checks if user is in the Users table
     * @return true if user is in the table
     */
    public boolean checkExistingUser() {
        try {
            String query = "SELECT * FROM Users WHERE " +
                    "username='" + username + "' AND " +
                    "password=SHA1('" + password + "')";

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement findUser = conn.createStatement();
            ResultSet users = findUser.executeQuery(query);

            if (!users.isBeforeFirst()) {
                return false;
            }
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return true;
    }

    /**
     * Creates a new user in the Users table by getting the information from the
     * user for each of the values
     * @param user username
     * @param pass password
     * @param email email
     * @param first first name
     * @param last last name
     */
    public void registerUser(String user, String pass, String email,
                             String first, String last) {

        username = user;
        password = pass;
        String sql = "insert into Users"
                + " (username, password, email, first_name, last_name)"
                + " values ('" + username + "', SHA1('" + password + "'), '" + email + "', '"
                + first + "', '" + last + "')";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement newUser = conn.createStatement();
            newUser.executeUpdate(sql);
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

}
