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
     */
    public static void getPDFTextFromFile (File file) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("temp_file.txt")));
        BufferedReader reader = new BufferedReader(new FileReader("temp_file.txt"))) {
            PDDocument pdfdoc = PDDocument.load(file);
            String docText = new PDFTextStripper().getText(pdfdoc);

//        BufferedReader reader = new BufferedReader(new StringReader(docText));
//        ArrayList<String> lines = new ArrayList<String>();
//        while (reader.ready()) {
//            String line = reader.readLine();
//        }
            writer.print(docText);
            pdfdoc.close();

            int counter = 0;
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.matches("\\S")) {
                    System.out.println(counter);
                } else {
                    System.out.println(counter);
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}