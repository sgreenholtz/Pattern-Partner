package com.patternpartner.Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet handles the form on the editTitle.jsp page
 * @author Sebastian Greenholtz
 */
@WebServlet(
        name = "updateTitle",
        urlPatterns = {"/updateTitle"}
)
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

        System.out.println("*****" + sql + "******");
    }


}