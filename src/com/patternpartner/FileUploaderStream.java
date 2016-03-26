package com.patternpartner;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;
import javax.servlet.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.util.*;
import org.apache.commons.io.*;

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

                InputStream stream = item.openStream();
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    processFieldItem(stream, name);
                } else {
                    String name = item.getName();
                    processUploadedFile(stream, name);
                }
            }

        }
    }

    /**
     * Extracts information from a regular text field in a form, in this case the title and knitOrCrochet field, and
     * sets the instance variable in PatternPreview
     * @param stream InputStream to process
     * @param fieldName name of the form field
     */
    public void processFieldItem(InputStream stream, String fieldName) {

        if (fieldName.equals("title")) {
            previewer.setTitle(readStream(stream));
        } else {
            previewer.setKnitOrCrochet(readStream(stream));
        }
    }

    /**
     * Processes file information and sends file to process based on type
     * @param stream InputStream to process
     * @param fileName name of the file that is being processed
     */
    public void processUploadedFile(InputStream stream, String fileName) {
        if (fileName.endsWith(".txt")) {
            processTxtFile(stream);
        } else if (fileName.endsWith(".pdf")) {
            processPDF(stream);
        }

    }

    /**
     * Extracts information from a txt file field in a form and sets the lines as the instance variable
     * in the PatternPreview
     * @param stream open stream to read from
     */
    public void processTxtFile(InputStream stream) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new InputStreamReader(stream))) {
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

    /**
     * Reads one line of text from an InputStream, and returns a String of that text
     * @param stream InputStream to read from
     * @return String of the text
     */
    public String readStream(InputStream stream) {
        String output = "";
        try (BufferedReader input = new BufferedReader(new InputStreamReader(stream))) {
            output = input.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return output;
    }

    public void processPDF(InputStream stream) {
        PDFHandler.getPDFText(stream);
    }
}
