package com.patternpartner.Servlets;

import com.patternpartner.ConfigureEnvVars;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This servlet handles the form on the editTitle.jsp page
 * @author Sebastian Greenholtz
 */
public class UpdateTitleServlet extends HttpServlet {

    /**
     *  Gets the new name from JSP editTitle and executes the update in the
     *  database
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        String newTitle = request.getParameter("newTitle");
        Integer id = new Integer(request.getParameter("id"));

        String sql = "UPDATE Patterns "
                + "SET title='" + newTitle + "' "
                + "WHERE patternID='" + id + "'";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());
            Statement updateStatement = conn.createStatement();
            updateStatement.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException exS) {
            exS.printStackTrace();
        } finally {
            response.sendRedirect("patternLibrary.jsp");
        }
    }


}