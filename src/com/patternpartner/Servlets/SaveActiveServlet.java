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

            String changeActive = "UPDATE PatternRows "
                    + "SET isActive = '1', repeatCount = ? "
                    + "WHERE patternID = ? "
                    + "AND lineID = ?";

            PreparedStatement statement = conn.prepareStatement(changeActive);
            statement.setString(1, repeatCount);
            statement.setString(2, patternID);
            statement.setString(3, newActiveRow);
            statement.executeUpdate();

            String changeInactive = "UPDATE PatternRows "
                    + "SET isActive = '0' "
                    + "WHERE patternID = ? "
                    + "AND lineID = ?";

            statement = conn.prepareStatement(changeInactive);
            statement.setString(1, patternID);
            statement.setString(2, oldActiveRow);
            statement.executeUpdate();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head></head>");
            out.println("<body>");
            out.println("<p>" + patternID + "</p>");
            out.println("<p>" + newActiveRow + "</p>");
            out.println("<p>" + repeatCount + "</p>");
            out.println("</body></html>");

//            String url = "patternLibrary";
//            response.sendRedirect(url);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}