package com.patternpartner;

import java.util.*;
import java.sql.*;

/**
 * Works with reviewComments.jsp page to show comments from the Comments table
 * @author Sebastian Greenholtz
 */
public class CommentViewer {

    private ArrayList<Map<String, String>> comments;

    /**
     * Empty constructor
     */
    public CommentViewer() {
        comments = new ArrayList<Map<String, String>>();
        getCommentsFromDatabase();
    }

    public ArrayList<Map<String, String>> getComments() {
        return comments;
    }

    /**
     * Gets ResultSet of comments from the Comments table and sends that to
     * createCommentsList() for further processing
     */
    public void getCommentsFromDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());
            Statement selectStatement = conn.createStatement();
            String sql = "SELECT * FROM Comments";
            ResultSet results = selectStatement.executeQuery(sql);
            createCommentsList(results);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    /**
     * Creates an ArrayList of Maps out of the results from the Comments table
     * so comments can be access in a similar manner as to how they are stored in the database.
     * Fields: Name, Email, Comment, Timestamp, Reviewed? 0 or 1
     * @param results ResultSet from the database select
     */
    public void createCommentsList(ResultSet results) throws SQLException {
        while (results.next()) {
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("id", results.getString("id"));
            resultMap.put("name", results.getString("name"));
            resultMap.put("email", results.getString("email"));
            resultMap.put("comment", results.getString("comment"));
            resultMap.put("timestamp", results.getString("timestamp"));
            resultMap.put("reviewed", results.getString("reviewed"));
            comments.add(resultMap);
        }

    }
}
