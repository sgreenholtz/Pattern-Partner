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
public class FileUploader {

    /**
     * Loads the file into memory and creates a list of submitted items to process.
     * @param request HttpServletRequest from submitted form
     */
    public void uploadFile(HttpServletRequest request) {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
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
        // Process the uploaded items
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();

            if (item.isFormField()) {
                processFormField(item);
            } else {
                processUploadedFile(item);
            }
        }
    }

    /**
     * Extracts information from a regular text field in a form
     * @param item FileItem to process
     * @return String value of input field
     */
    public String processFormField(FileItem item) {
        if (item.isFormField()) {
            return item.getString();
        }
    }

    /**
     * Extracts information from a file field in a form
     * @param item FileItem to process
     */
    public void processUploadedFile(FileItem item) {
        if (!item.isFormField()) {
            String fieldName = item.getFieldName();
            String fileName = item.getName();
            String contentType = item.getContentType();
            boolean isInMemory = item.isInMemory();
            long sizeInBytes = item.getSize();
        }
    }
}
