package com.patternpartner;

import java.io.*;

/**
 * Command line app for testing errors throughout the code
 * @author Sebastian Greenholtz
 */
public class ErrorTester {

    public static void main(String[] args) {
        Pattern pat = new Pattern();
        try (BufferedReader input = new BufferedReader(new FileReader("Sample2.txt"));
            PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter("SampleOutput.txt")))) {
            while (input.ready()) {
                String line = input.readLine();
                if (!(line.isEmpty() || line.trim().isEmpty())) {
                    pat.getDescription().add(line);
                }
            }

            write.print(pat.listToString(pat.getDescription()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
