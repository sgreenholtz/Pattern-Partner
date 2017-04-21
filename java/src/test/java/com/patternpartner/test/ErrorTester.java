package com.patternpartner.test;

import java.util.*;
import java.io.*;

/**
 * Command line app for testing errors throughout the code
 * @author Sebastian Greenholtz
 */
public class ErrorTester {

    public static void main(String[] args) {
        String fileLocation = System.getProperty("java.io.tmpdir");
        String fileName =  "test.txt";
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileLocation + fileName)))) {
            writer.println("this is a test");
            writer.println(fileLocation + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
