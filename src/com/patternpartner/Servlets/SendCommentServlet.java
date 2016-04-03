package com.patternpartner.Servlets;

import java.io.*;
import java.sql.*;
import java.time.*;
import java.time.format.*;
import javax.servlet.*;
import javax.servlet.http.*;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
        String timestamp = formatter.format(LocalDateTime.now());

        String sql = "INSERT INTO Comments "
                + "(name, email, comment, timestamp) "
                + "values ('"
                + name + "', '"
                + email + "', '"
                + comment + "' ,'"
                + timestamp + "')";

        response.setContentType("text/html");
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD></HEAD>");
        out.print("<BODY>");
        out.print(sql);
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();

    }
}