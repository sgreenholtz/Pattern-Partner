package com.patternpartner;
import java.io.*;
import java.util.*;

/**
 * This class allows the user to preview the pattern and make changes before sending the pattern to the database. Methods
 * set the title, materials, and description lines to add to database.
 * @author Sebatian Greenholtz
 */
public class PatternPreview {

    static char RECORD_SEPARATOR = '\u241E';
    static String LINE_SEPARATOR = System.lineSeparator();
    private ArrayList<String> lines;
    private Pattern newPattern = new Pattern();

    /**
     * No argument constructor
     */
    public PatternPreview() {}

    /**
     * Constructor that creates the lines ArrayList by reading through the file
     * at path indicated by param
     * @param path the path to the file
     */
    public PatternPreview(String path) {
        lines = new ArrayList<String>();
        String line = null;

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            while (in.ready()) {
                line = in.readLine();
                lines.add(line);
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
     * Constructor to set instance variable lines to a pre-formatted ArrayList
     * @param list ArrayList of pre-formatted lines
     */
    public PatternPreview (ArrayList<String> list) {
        lines = list;
    }

    /**
     * This method displays the entire pattern as formatted on the command line,
     * with line numbers to help with adding additional record separator symbols
     */
    public void showPattern() {
        int lineCount = 0;

        for (String line : lines) {
            System.out.println(lineCount + ". " + line);
            lineCount++;
        }
    }

    /**
     * This method shows the pattern and asks the user to add record separator, adds it, then shows
     * the pattern again, until the user enters the quit symbol
     */
    public void editLineSeparators() {
        CMDHelper helper = new CMDHelper();
        String input = "";

        while (!(input.equals("q"))) {
            showPattern();
            System.out.println(LINE_SEPARATOR + "What line would you like to add a record separator to?");
            input = helper.getUserInput("Type 'q' to finish: ");

            if (!(input.equals("q"))) {
                Integer index = Integer.parseInt(input);
                addRecordSeparatorToLine(index);
                System.out.println(LINE_SEPARATOR);
            }
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
