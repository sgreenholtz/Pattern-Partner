package com.patternpartner;
import java.io.*;
import java.util.*;

/**
 * This class facilitates the adding of a new pattern
 * Created by Kolya on 2016-02-07.
 */
public class AddNewPattern {

    static char RECORD_SEPARATOR = '\u241E';
    private CMDHelper helper;
    private String path;
    private String rowDelimiter;
    private Pattern newPattern;

    /**
     * This is the no argument constructor
     */
    public AddNewPattern() {
        helper = new CMDHelper();
        path = setInputFile();
        rowDelimiter = setRowDelimiter();
        newPattern = constructPattern();
    }

    /**
     * Gets the values for path
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets the value for rowDelimiter
     * @return rowDelimiter
     */
    public String getRowDelimiter() {
        return rowDelimiter;
    }

    /**
     * This method asks the user what word is used to delimit rows
     * @return delimiter the word used for rows
     */
    public String setRowDelimiter() {
        System.out.println("What word is used to mark off rows?");
        String delimiter = helper.getUserInput("For example, \"row\", \"round\", numbers: ");

        return delimiter;
    }

    /**
     * This method asks the user for a file to process. Works best with full path of the file.
     * @returns inputPath The path of the file to add
     */
    public String setInputFile() {
        String inputPath = helper.getUserInput("What file would you like to add?");

        return inputPath;
    }

    /**
     * Adds record separator characters in front of the lines with specified delimiter
     * @return lines
     */
    public ArrayList<String> addRecordSeparator() {
        String line = null;
        ArrayList<String> lines = new ArrayList<String>();

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            while (in.ready()) {
                line = in.readLine();
                if (line.startsWith(getRowDelimiter())) {
                    lines.add(RECORD_SEPARATOR + line);
                } else {
                    lines.add(line);
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

        return lines;
    }

    /**
     * Creates a Pattern object from the file after new lines and preview
     * @return newPattern Pattern with pieces processed
     */
    public Pattern constructPattern() {
        PatternPreview preview = new PatternPreview(addRecordSeparator());
        newPattern = new Pattern(preview.setName(), preview.setDescription(), preview.setMaterials(), preview.setRows());
        return newPattern;
    }


}
