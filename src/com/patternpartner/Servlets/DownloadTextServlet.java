package com.patternpartner.Servlets;

import com.patternpartner.Pattern;
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
        String fileLocation = System.getProperty("java.io.tmpdir") + "/";
        String fileName = pattern.getName().replace(" ", "") + ".txt";
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileLocation + fileName)))) {
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

//            String url = "patternLibrary";
//            response.sendRedirect(url);


            // Find this file id in database to get file name, and file type

            // You must tell the browser the file type you are going to send
            // for example application/pdf, text/plain, text/html, image/jpg
            response.setContentType("text/plain");

            // Make sure to show the download dialog
            response.setHeader("Content-disposition","attachment; filename=" + fileName);

            // Assume file name is retrieved from database
            // For example D:\\file\\test.pdf

            File my_file = new File(fileLocation + fileName);

            // This should send the file to browser
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(my_file);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}