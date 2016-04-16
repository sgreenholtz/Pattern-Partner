package com.patternpartner.Servlets;

import com.patternpartner.Pattern;
import com.patternpartner.ViewPattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        Integer patternID = Integer.getInteger(request.getParameter("patternID"));

        ViewPattern patternViewer = new ViewPattern();

        Pattern pattern = patternViewer.getPattern(patternID);

//        try (PrintWriter writer = new PrintWriter(new BufferedWriter
//                (new FileWriter(pattern.getName() + ".txt")))) {
            try {

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("</head>");
                out.println("<body>");
//                out.println("<p>Name: " + pattern.getName() + "</p>");
//                out.println("<p>Description" + pattern.listToString(pattern.getDescription()) + "</p>");
                out.println("<p>Text</p>gi");
                out.println("</body>");
//            writer.println(pattern.getName());
//            writer.println(pattern.listToString(pattern.getDescription()));
//            writer.println("Materials");
//            for (String material : pattern.getMaterials()) {
//                writer.println(material);
//            }
//            writer.println("Instructions");
//            for (String row : pattern.getPatternRows()) {
//                writer.println(row);
//            }

//            String url = "patternLibrary";
//            response.sendRedirect(url);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}