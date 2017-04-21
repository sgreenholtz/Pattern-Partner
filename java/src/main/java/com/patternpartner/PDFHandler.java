package com.patternpartner;

import org.apache.pdfbox.pdmodel.*;
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
     * @return ArrayList of lines in the document
     */
    public static ArrayList<String> getPDFText (File file) {
        ArrayList<String> lines = null;
        try {
            PDDocument document = PDDocument.load(file);
            lines = getLinesFromPDF(document);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Takes in an InputStream and extracts text from it in String form
     * @param stream InputStream to read from
     * @return ArrayList of lines in the document
     */
    public static ArrayList<String> getPDFText (InputStream stream) {
        ArrayList<String> lines = null;
        try {
            PDDocument document = PDDocument.load(stream);
            lines = getLinesFromPDF(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Reads through a PDDocument object and extracts the text line by line
     * @param document document to read from
     * @throws IOException
     * @return ArrayList of lines in the document
     */
    private static ArrayList<String> getLinesFromPDF (PDDocument document)
        throws IOException {
        String docText = new PDFTextStripper().getText(document);
        ArrayList<String> lines = new ArrayList<>();
        for (String line : docText.split("\\n")) {
            if (line.matches("^.+\\w.*$")) {
                lines.add(line);
            }
        }

        return lines;
    }
}