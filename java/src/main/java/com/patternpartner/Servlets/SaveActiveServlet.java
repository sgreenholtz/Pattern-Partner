package com.patternpartner.Servlets;

import com.patternpartner.ConfigureEnvVars;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Saves the active row indicated by the user in the viewPattern page
 * @author Sebastian Greenholtz
 */

public class SaveActiveServlet extends HttpServlet {

    /**
     * Updates the database with the active row, then returns the user to the
     * Pattern library
     * @param request Http request
     * @param response Http response
     * @throws IOException
     * @throws ServletException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        String newActiveRow = request.getParameter("newActive");
        String oldActiveRow = request.getParameter("oldActive");
        String patternID = request.getParameter("patternID");
        String repeatCount = request.getParameter("repeat");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());

            String changeInactive = "UPDATE PatternRows "
                    + "SET isActive = '0' "
                    + "WHERE patternID = ? "
                    + "AND lineID = ?";

            PreparedStatement statement = conn.prepareStatement(changeInactive);
            statement.setString(1, patternID);
            statement.setString(2, oldActiveRow);
            statement.executeUpdate();

            String changeActive = "UPDATE PatternRows "
                    + "SET isActive = '1' "
                    + "WHERE patternID = ? "
                    + "AND lineID = ?";

            statement = conn.prepareStatement(changeActive);
            statement.setString(1, patternID);
            statement.setString(2, newActiveRow);
            Integer updated = statement.executeUpdate();

            String updateRepeat = "UPDATE PatternRows "
                    + "SET repeatCount = ? "
                    + "WHERE patternID = ? "
                    + "AND lineID = ?";

            statement = conn.prepareStatement(updateRepeat);
            statement.setString(1, repeatCount);
            statement.setString(2, patternID);
            statement.setString(3, newActiveRow);
            statement.executeUpdate();

            String url = "patternLibrary";
            response.sendRedirect(url);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}