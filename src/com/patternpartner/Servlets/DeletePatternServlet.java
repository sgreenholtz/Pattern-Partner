package com.patternpartner.Servlets;

import com.patternpartner.ConfigureEnvVars;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Deletes the pattern from the database
 * @author Sebastian Greenholtz
 */

public class DeletePatternServlet extends HttpServlet {

    /**
     * Deletes all the pattern components of the requested pattern, then returns
     * the user to the Pattern library
     * @param request Http request
     * @param response Http response
     * @throws IOException
     * @throws ServletException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String patternID = request.getParameter("patternID");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());
            String sql = "DELETE FROM Patterns WHERE patternID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, patternID);
            preparedStatement.executeUpdate();

            sql = "DELETE FROM Materials WHERE patternID = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, patternID);
            preparedStatement.executeUpdate();

            sql = "DELETE FROM PatternRows WHERE patternID = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, patternID);
            preparedStatement.executeUpdate();


            String url = "patternLibrary";
            response.sendRedirect(url);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}