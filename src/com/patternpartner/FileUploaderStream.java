package com.patternpartner;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;
import javax.servlet.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.util.*;

/**
 * This class implements the FileUploader API to assist in file uploads
 * @author Sebastian Greenholtz
 * @see <a href="FileUploader.html">File Uploader, processes in memory</a>
 */
public class FileUploaderStream extends HttpServlet {

    PatternPreview previewer = new PatternPreview();

    public PatternPreview getPreviewer() {
        return previewer;
    }

    /**
     * Loads contents of submitted form as a stream and processes them accordingly.
     * @param request HttpServletRequest from submitted form
     * @param context HttpServlet Context
     */
    public void uploadFile(HttpServletRequest request, ServletContext context)
        throws IOException, FileUploadException {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload();

            // Parse the request
            FileItemIterator iter = upload.getItemIterator(request);
            while (iter.hasNext()) {
                FileItemStream item = iter.next();
                String name = item.getFieldName();
                parseItemRequest(item, name);

                InputStream stream = item.openStream();
                if (item.isFormField()) {
                    processFieldItem();
                } else {


                }
            }

        }
    }


    /**
     * Handles parsing through the items in the stream and sending them for appropriate processing
     * @param item FileStreamItem to process
     * @param name Name of the field that the item is coming from
     */
    public void parseItemRequest(FileItemStream item, String name) throws IOException {
        if (name.equals("title")) {
            setTitle(item);
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
            processTxtFile(stream);
        } else if (fileName.endsWith(".pdf")) {

        }

    }

    public void setTitle(FileItemStream stream) {

    }

    /**
     * Extracts information from a txt file field in a form and sets the lines as the instance variable
     * in the PatternPreview
     * @param stream open stream to read from
     */
    public void processTxtFile(FileItemStream stream) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new InputStreamReader(stream.openStream())) {
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
