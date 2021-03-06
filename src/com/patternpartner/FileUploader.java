package com.patternpartner;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;
import javax.servlet.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;

/**
 * This class implements the FileUploader API to assist in file uploads
 * @author Sebastian Greenholtz
 */
public class FileUploader extends HttpServlet {

    PatternPreview previewer = new PatternPreview();

    public PatternPreview getPreviewer() {
        return previewer;
    }

    /**
     * Loads the file into memory and creates a list of submitted items to process.
     * @param request HttpServletRequest from submitted form
     * @param context HttpServlet Context
     */
    public void uploadFile(HttpServletRequest request, ServletContext context) {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            File repository = (File) context.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request
            try {
                List<FileItem> items = upload.parseRequest(request);
                processFile(items);
            } catch (FileUploadException ex) {
                ex.printStackTrace();
            }

        }
    }

    /**
     * Iterates through submitted items list and processes according to type
     * @param items List of FileItems to process
     */
    public void processFile(List<FileItem> items) {
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();

            if (item.isFormField()) {
                processFieldItem(item);
            } else {
                processUploadedFile(item);
            }
        }
    }

    /**
     * Extracts information from a regular text field in a form, in this case the title and knitOrCrochet field, and
     * sets the instance variable in PatternPreview
     * @param item FileItem to process
     */
    public void processFieldItem(FileItem item) {
        if (item.getFieldName().equals("title")) {
            previewer.setTitle(item.getString());
        } else {
            previewer.setKnitOrCrochet(item.getString());
        }
    }

    /**
     * Processes file information and sends file to process based on type
     * @param item FileItem to process
     */
    public void processUploadedFile(FileItem item) {
        String fileName = item.getName();
        if (fileName.endsWith(".txt")) {
            processTxtFile(item);
        } else if (fileName.endsWith(".pdf")) {

        }

    }

    /**
     * Extracts information from a txt file field in a form and sets the lines as the instance variable
     * in the PatternPreview
     * @param item FileItem to process
     */
    public void processTxtFile(FileItem item) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new InputStreamReader(item.getInputStream()))) {
            while (input.ready()) {
                String line = input.readLine();
                if (!(line.isEmpty() || line.trim().isEmpty())) {
                    lines.add(line);
                }
            }
            previewer.setLines(lines);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
