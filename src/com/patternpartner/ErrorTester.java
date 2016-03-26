package com.patternpartner;

import java.io.*;

/**
 * Command line app for testing errors throughout the code
 * @author Sebastian Greenholtz
 */
public class ErrorTester {

    public static void main(String[] args) throws IOException {
        PDFHandler.getPDFText(new File("dishcloths.pdf"));
    }
}
