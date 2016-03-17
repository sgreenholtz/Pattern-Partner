package com.patternpartner;

import org.apache.pdfbox.io.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import java.io.*;

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
        String para = new PDFTextStripper().getParagraphStart();
        System.out.println(docText);
    }

    public static void getPDFTextFromStream (InputStream stream) throws IOException {
        RandomAccess raf = new RandomAccessBuffer();
//        PDFStreamParser parser = new PDFStreamParser(stream, raf);
    }
}