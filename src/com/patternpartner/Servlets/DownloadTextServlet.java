package com.patternpartner.Servlets;

import com.patternpartner.ViewPattern;
import com.patternpartner.Pattern;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Allows users to download the pattern as a TXT file for editing and re-uploading
 * @author Sebastian Greenholtz
 */

public class DownloadTextServlet extends HttpServlet {

    /**
     * Downloads the pattern as a TXT file
     * @param request Http request
     * @param response Http response
     * @throws IOException
     * @throws ServletException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Integer patternID = new Integer(request.getParameter("patternID"));

        ViewPattern patternViewer = new ViewPattern();

        Pattern pattern = patternViewer.getPattern(patternID);



    }

}