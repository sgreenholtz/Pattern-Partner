package com.patternpartner;
import java.io.*;
import java.util.*;

/**
 * This class allows the user to preview the pattern txt file and make changes before sending the pattern to the database
 * Created by Kolya on 2016-02-02.
 */
public class PatternPreview {

    static char RECORD_SEPARATOR = '\u241E';
    private ArrayList<String> lines = new ArrayList<String>();
    /**
     * This method displays the entire pattern as formatted on the command line
     * @param path the path to the file (if saved in lib folder just type file name)
     */
    public void showPattern(String path) {
        int lineCount = 0;

        String line = null;
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            while (in.ready()) {
                line = in.readLine();
                lines.add(line);
                System.out.println(lineCount + ". " + line);
                lineCount++;
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
    }

    /**
     * This method adds a record separator symbol before the line specified
     * @param index index of the line to add the record separator symbol to
     */
    public void addRecordSeparatorToLine(int index) {
        String line = lines.get(index);
        String newLine = RECORD_SEPARATOR + line;
        lines.remove(index);
        lines.add(index, newLine);
    }

}
