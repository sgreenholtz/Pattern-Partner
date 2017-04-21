package com.patternpartner.Servlets;

import com.patternpartner.entities.Pattern;
import com.patternpartner.ViewPattern;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

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
        Integer patternID = new Integer(request.getParameter("id"));
        ViewPattern patternViewer = new ViewPattern();
        Pattern pattern = patternViewer.getPattern(patternID);
        String fileName = pattern.getName().replace(" ", "") + ".txt";
        try (PrintWriter writer = new PrintWriter(response.getOutputStream())) {
            response.setContentType("text/plain");
            response.setHeader("Content-disposition","attachment; filename=" + fileName);
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}