package com.patternpartner;

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * Command line app for testing errors throughout the code
 * @author Sebastian Greenholtz
 */
public class ErrorTester {

    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = PDFHandler.getPDFText(new File("Baby_Sophisticate.pdf"));
        for (String line : lines) {
            System.out.println(line);
        }

    }
}
