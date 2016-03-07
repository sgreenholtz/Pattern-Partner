package com.patternpartner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.*;

/**
 * This class uses the PDFBox library from Apache to handle the upload of
 * PDF files
 * @author Sebastian Greenholtz
 */
public class PDFHandler {

    public static void main(String[] args) throws IOException {
        File pdfFile = new File("dishcloths.pdf");
        PDDocument pdfdoc = PDDocument.load(pdfFile);
        String docText = new PDFTextStripper().getText(pdfdoc);
        System.out.println(docText);

    }
}