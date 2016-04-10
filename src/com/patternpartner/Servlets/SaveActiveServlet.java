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
        String newActiveRow = request.getParameter("oldActive");
        String oldActiveRow = request.getParameter("oldActive");
        String patternID = request.getParameter("patternID");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());
            Statement update = conn.createStatement();

            String changeActive = "UPDATE PatternRows "
                    + "SET isActive = '1' "
                    + "WHERE patternID = '" + patternID + "' "
                    + "AND lineID = '" + newActiveRow + "'";

            String changeInactive = "UPDATE PatternRows "
                    + "SET isActive = '0' "
                    + "WHERE patternID = '" + patternID + "' "
                    + "AND lineID = '" + oldActiveRow + "'";

            update.executeUpdate(changeInactive);
            update.executeUpdate(changeActive);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>" + changeActive + "</p>");
            out.println("<p>" + changeInactive + "</p>");
            out.println("</body>");

//            String url = "patternLibrary";
//            response.sendRedirect(url);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}