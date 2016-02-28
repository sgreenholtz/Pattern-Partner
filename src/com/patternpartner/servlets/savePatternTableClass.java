package com.patternpartner.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This is a servlet to use with AJAX on the patternTable.jsp. It is responsible for saving and loading the "class" name
 * for each line in the pattern display, so users can preview the data before it is loaded into the database.
 * <br />
 * May also be used for saving the active line in the display portion of the application.
 * @author Sebastian Greenholtz
 */
public class savePatternTableClass extends HttpServlet {

    /**
    *  Handles HTTP GET requests.
    *
    * @param  request                   the HttpServletRequest object
    * @param  response                   the HttpServletResponse object
    * @exception  ServletException  if there is a Servlet failure
    * @exception  IOException       if there is an IO failure
    */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        this.doPost(request, response);
    }



}