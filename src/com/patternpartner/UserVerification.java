package com.patternpartner;
import java.sql.*;

/**
 * This class logs in the user and checks database for existing user or new user
 * @author Sebastian Greenholtz
 */
public class UserVerification {
    static String DB_URL = "jdbc:mysql://localhost:3306/PatternPartner?useSSL=false";
    static String USERNAME = "root";
    static String PASSWORD = "student";

    private String username;
    private String password;
    private String email;

    /**
     * Gets value of email
     * @return value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets value of username
     * @return value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets value of password
     * @return value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Allows a registered user to login on the command line. If the
     * user is not already registered, runs the registration methodgit
     */
    public void login() {
        CMDHelper helper = new CMDHelper();
        System.out.println("Please log in.");
        username = helper.getUserInput("Username: ");
        password = helper.getUserInput("Password: ");

        if (checkExistingUser()) {

        }
    }

    /**
     * Checks if user is in the Users table
     * @return true if user is in the table
     */
    public boolean checkExistingUser() {
        boolean isNull = false;

        try {

            String query = "SELECT * FROM Users WHERE " +
                    "username='" + username + "' AND " +
                    "password=SHA1('" + password + "')";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement findUser = conn.createStatement();
            ResultSet users = findUser.executeQuery(query);

            isNull = users.wasNull();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return !(isNull);
    }
}
