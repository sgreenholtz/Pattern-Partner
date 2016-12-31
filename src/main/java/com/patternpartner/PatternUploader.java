package com.patternpartner;
import com.patternpartner.entities.Pattern;

import java.sql.*;
import java.util.*;

/**
 * This class facilitates uploading the formatted pattern into the database.
 * This class uses Prepared Statements rather than regular statements
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
     * Creates Prepared Statement for Patterns table
     * @param conn Connection to the database
     * @return Prepared statement to insert data into Patterns table
     * @throws SQLException
     */
    private PreparedStatement createPatternsStatement(Connection conn)
        throws SQLException{
        String sql = "INSERT INTO Patterns"
                + " (username, title, description, knitOrCrochet)"
                + " values (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, pattern.getName());
        statement.setString(3, pattern.listToString(pattern.getDescription()));
        statement.setString(4, pattern.getKnitOrCrochet());

        return statement;
    }

    /**
     * Creates prepared statements for Pattern Rows table
     * @param patternID patternID from the newly-created item in Patterns table
     * @param conn Connection to the database
     * @return ArrayList of prepared statements to insert each row into Pattern Rows table
     * @throws SQLException
     */
    private ArrayList<PreparedStatement> createPatternRowsStatement(Integer patternID, Connection conn)
        throws SQLException {
        int lineNumber = 0;
        ArrayList<PreparedStatement> statements = new ArrayList<PreparedStatement>();

        while (lineNumber < pattern.getPatternRows().size()) {

            String sql = "INSERT INTO PatternRows"
                    + " (patternID, lineID, lineText, isActive, isRepeat)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, patternID);
            statement.setInt(2, lineNumber);
            statement.setString(3, pattern.getPatternRows().get(lineNumber));
            statement.setInt(4, 0);
            statement.setInt(5, 0);

            statements.add(statement);
            lineNumber++;
        }

        return statements;
    }

    /**
     * Creates prepared statements for Materials table
     * @param patternID patternID from the newly-created item in Patterns table
     * @param conn Connection to the database
     * @return ArrayList of prepared statements to insert each row into materials table
     * @throws SQLException
     */
    private ArrayList<PreparedStatement> createMaterialsStatement(Integer patternID, Connection conn)
        throws SQLException{
        int lineNumber = 0;
        ArrayList<PreparedStatement> statements = new ArrayList<PreparedStatement>();

        while (lineNumber < pattern.getMaterials().size()) {

            String sql = "INSERT INTO Materials"
                    + " (patternID, materialID, material)"
                    + " values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, patternID);
            statement.setInt(2, lineNumber);
            statement.setString(3, pattern.getMaterials().get(lineNumber));

            statements.add(statement);
            lineNumber++;
        }
        return statements;
    }

    /**
     * Executes the update for Users, Patterns, Materials and PatternRows
     */
    public void upload() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());

            // Adds pattern to Patterns table
            PreparedStatement insert = createPatternsStatement(conn);
            insert.executeUpdate();

            // Gets the patternID for the pattern that was just added
            Statement insertStatement = conn.createStatement();
            ResultSet patternIDResult = insertStatement.executeQuery("SELECT LAST_INSERT_ID();");
            Integer patternID = null;
            while (patternIDResult.next()) {
                patternID = patternIDResult.getInt("LAST_INSERT_ID()");
            }

            // Uses patternID to create the statements and upload to Pattern Rows table
            for (PreparedStatement statement : createPatternRowsStatement(patternID, conn)) {
                statement.executeUpdate();
            }

            // Uses pattern ID to create the statements and upload to Materials table
            for (PreparedStatement statement : createMaterialsStatement(patternID, conn)) {
                statement.executeUpdate();
            }
        } catch (ClassNotFoundException cNFex) {
            cNFex.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

    }
}