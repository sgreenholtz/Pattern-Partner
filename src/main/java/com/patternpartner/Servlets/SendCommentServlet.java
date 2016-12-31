package com.patternpartner.Servlets;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.patternpartner.ConfigureEnvVars;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Adds comment to the Comments table so the developer can review comments and reply,
 * if necessary
 * @author Sebastian Greenholtz
 */
public class SendCommentServlet extends HttpServlet {

    /**
     *  Gets the comment from faqComments and add to the Comments table
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String name = StringEscapeUtils.escapeEcmaScript(request.getParameter("name"));
        String email = StringEscapeUtils.escapeEcmaScript(request.getParameter("inputEmail"));
        String comment = StringEscapeUtils.escapeEcmaScript(request.getParameter("comment"));
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timestamp = dateFormat.format(date);

        String sql = "INSERT INTO Comments "
                + "(name, email, comment, timestamp) "
                + "values ('"
                + name + "', '"
                + email + "', '"
                + comment + "' ,'"
                + timestamp + "')";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConfigureEnvVars vars = new ConfigureEnvVars();
            Connection conn = DriverManager.getConnection(vars.getURL(), vars.getUsername(), vars.getPassword());
            Statement insertStatement = conn.createStatement();
            insertStatement.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException exS) {
            exS.printStackTrace();
        } finally {
            response.sendRedirect("home.jsp");
        }

    }
}