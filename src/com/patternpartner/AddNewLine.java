package com.patternpartner;
import java.io.*;
import java.util.*;

/**
 * This class reads through a file and adds a new line before the word "row"
 * Created by Kolya on 2016-01-31.
 */
public class AddNewLine {



    /**
     * This method sets the instance variable pattern.
     */
    public void setPattern() {
        pattern = new NewPattern();
    }

    /**
     * This method reads through the file and adds a new line whenever it sees the word "row"
     * then writes that row to the new file
     * @return newFileName the name of the newly created file
     */
    public ArrayList<String> addNewLine() {
        String line = null;
        ArrayList<String> lines = new ArrayList<String>();

        try (BufferedReader in = new BufferedReader(new FileReader(pattern.getPath()));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("lib/" + newFileName + ".txt")))) {
            while (in.ready()) {
                line = in.readLine();
                if (line.startsWith(pattern.getRowDelimiter())) {
                    writer.println(RECORD_SEPARATOR + line);
                } else {
                    writer.println(line);
                }
            }
        } catch (FileNotFoundException fnfEx) {
            System.out.println("You have encountered a file-not-found error.");
            fnfEx.printStackTrace();
        } catch (IOException ioEx) {
            System.out.println("You have encountered an IO error.");
            ioEx.printStackTrace();
        } catch (Exception ex) {
            System.out.println("You have encountered a not-otherwise-specified error.");
            ex.printStackTrace();
        }

        return newFileName + ".txt";

    }

}
