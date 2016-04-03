package com.patternpartner.Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Adds comment to the Comments table so the developer can use it
 * @author Sebastian Greenholtz
 */
public class SendCommentServlet extends HttpServlet {

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

    }
}