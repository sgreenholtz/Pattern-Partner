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

    public void uploadFile(HttpServletRequest request) {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

// Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

// Parse the request
        List<FileItem> items = upload.parseRequest(request);
    }
}
