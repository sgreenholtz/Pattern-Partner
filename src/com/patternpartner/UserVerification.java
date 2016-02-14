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
    private String firstName;

    /**
     * Gets value of username
     * @return value of username
     */
    public String getUsername() {
        return username;
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
            registerUser();
        }
        System.out.println("You are logged in as " + firstName);
    }

    /**
     * Checks if user is in the Users table
     * @return false if user is in the table
     */
    public boolean checkExistingUser() {
        try {
            String query = "SELECT * FROM Users WHERE " +
                    "username='" + username + "' AND " +
                    "password=SHA1('" + password + "')";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement findUser = conn.createStatement();
            ResultSet users = findUser.executeQuery(query);

            if (!users.isBeforeFirst()) {
                return true;
            } else {
                users.next();
                firstName = users.getString("first_name");
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return false;
    }

    /**
     * Creates a new user in the Users table by getting the information from the
     * user for each of the values
     */
    public void registerUser() {
        CMDHelper helper = new CMDHelper();
        System.out.println("You need to create an account to use Pattern Partner.");

        username = helper.getUserInput("Enter a new username: ");
        password = helper.getUserInput("Enter a password: ");
        String passConfirm = helper.getUserInput("Confirm password: ");
        String email = helper.getUserInput("Enter your email: ");
        firstName = helper.getUserInput("Enter your first name: ");
        String lastName = helper.getUserInput("Enter your last name: ");

        while (!(password.equals(passConfirm))) {
            System.out.println(System.lineSeparator() + "Please re-enter passwords so they match.");
            password = helper.getUserInput("Enter a password: ");
            passConfirm = helper.getUserInput("Confirm password: ");
        }

        String sql = "insert into Users"
                + " (username, password, email, first_name, last_name)"
                + " values ('" + username + "', SHA1('" + password + "'), '" + email + "', '"
                + firstName + "', '" + lastName + "')";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement newUser = conn.createStatement();
            newUser.executeUpdate(sql);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

}