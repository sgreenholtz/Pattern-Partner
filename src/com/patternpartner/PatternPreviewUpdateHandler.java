package com.patternpartner;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;

/**
 * This servlet assists in updating the PatternPreview as the user goes through the pages.
 * @author Sebastian Greenholtz
 */
public class PatternPreviewUpdateHandler extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     * @param  request                   the HttpServletRequest object
     * @param  response                   the HttpServletResponse object
     * @exception ServletException  if there is a Servlet failure
     * @exception IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.getInteger(request.getParameter("id"));
    }
}
