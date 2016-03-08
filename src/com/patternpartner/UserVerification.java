package com.patternpartner;
import java.sql.*;
import java.util.*;

/**
 * This class logs in the user and checks database for existing user or new user
 * @author Sebastian Greenholtz
 */
public class UserVerification {

    private String username;
    private String password;
    private Properties properties;

    /**
     * Empty constructor
     */
    public UserVerification() {
    }

    /**
     * Constructor uses username and password from the table to
     * set instance variables
     */
    public UserVerification(String user, String pass) {
        this();
        this.username = user;
        this.password = pass;
        this.properties = new LoadProperties().loadProperties("patternpartner.properties");
    }

    /**
     * Gets value of username
     *
     * @return value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Checks if user is in the Users table
     *
     * @return true if user is in the table
     */
    public boolean checkExistingUser() {
        try {
            String query = "SELECT * FROM Users WHERE " +
                    "username='" + username + "' AND " +
                    "password=SHA1('" + password + "')";

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user"), properties.getProperty("db.password"));
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
     *
     * @param user  username
     * @param pass  password
     * @param email email
     * @param first first name
     * @param last  last name
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

            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
            String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
            String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

            String url = String.format(":mysql://%s:%s/jbossas", host, port);
            Connection conn = DriverManager.getConnection(url, username, password);


            Statement newUser = conn.createStatement();
            System.out.println(newUser);
            System.out.println(sql);
            newUser.executeUpdate(sql);
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}