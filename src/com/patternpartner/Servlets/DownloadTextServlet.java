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
     * @throws ServletException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        Integer patternID = new Integer(request.getParameter("patternID"));

        ViewPattern patternViewer = new ViewPattern();

        Pattern pattern = patternViewer.getPattern(patternID);

        try (PrintWriter writer = new PrintWriter(new BufferedWriter
                (new FileWriter("temp/" + pattern.getName() + ".txt")))) {
            writer.println(pattern.getName());
            writer.println(pattern.listToString(pattern.getDescription()));
            writer.println("Materials");
            for (String material : pattern.getMaterials()) {
                writer.println(material);
            }
            writer.println("Instructions");
            for (String row : pattern.getPatternRows()) {
                writer.println(row);
            }

            String url = "patternLibrary";
            response.sendRedirect(url);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}