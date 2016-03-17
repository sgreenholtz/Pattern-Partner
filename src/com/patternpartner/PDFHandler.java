package com.patternpartner;

import org.apache.pdfbox.io.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.*;
import java.util.ArrayList;

/**
 * This class uses the PDFBox library from Apache to handle the upload of
 * PDF files
 * @author Sebastian Greenholtz
 */
public class PDFHandler {

    /**
     * Takes in a PDF file and extracts text from it in String form
     * @param file PDF file to extract text from
     * @throws IOException if there is an error reading the file
     */
    public static void getPDFTextFromFile (File file) throws IOException {
        PDDocument pdfdoc = PDDocument.load(file);
        String docText = new PDFTextStripper().getText(pdfdoc);
        BufferedReader reader = new BufferedReader(new StringReader(docText));
        ArrayList<String> lines = new ArrayList<String>();
        while (reader.ready()) {
            String line = reader.readLine();
        }
        pdfdoc.close();
    }
}