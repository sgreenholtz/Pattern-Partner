package com.patternpartner.Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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
        request.getParameter("active");
        request.getParameter("id");gi
    }


}