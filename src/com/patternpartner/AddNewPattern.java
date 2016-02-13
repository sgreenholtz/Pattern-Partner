package com.patternpartner;
import java.io.*;
import java.util.*;

/**
 * This class facilitates the adding of a new pattern. When this class is invoked, the user is asked for the file to
 * read from, the delimiter to use to separate out the lines of the pattern, and a new Pattern object is created using
 * the PatternPreivew class to create the ArrayLists for the components of the pattern (name, materials, description, rows).
 * <br />
 * Once the user has confirmed the Pattern has the correct component parts of the pattern, the PatternUploader is called to
 * upload the pattern to the database.
 *
 * @author Sebastian Greenholtz
 * @see <a href="Pattern.html">Pattern</a>
 * @see <a href="PatternPreview.html">PatternPreview</a>
 * @see <a href="PatternUploader.html">PatternUploader</a>
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

        while(reviewPatternParts()) {
            newPattern = constructPattern();
        }
        System.out.println("Successful pattern adding.");
        //new PatternUploader(newPattern);
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
     * @returns new Pattern object (for constructor)
     */
    public Pattern constructPattern() {
        PatternPreview preview = new PatternPreview(addRecordSeparator());
        preview.editLineSeparators();

        newPattern = new Pattern(preview.setName(), preview.setDescription(),
                preview.setMaterials(), preview.setRows());
        return newPattern;
    }

    /**
     * Shows the parts of the pattern on the command line for user to confirm before upload to database
     * @return true if ready to upload to database, false if more changes are needed
     */
    public boolean reviewPatternParts() {

        System.out.println("Name: " + newPattern.getName());

        System.out.println(System.lineSeparator());
        System.out.println("Materials:");
        for (String line : newPattern.getMaterials()) {
            System.out.println(line);
        }

        System.out.println(System.lineSeparator());
        System.out.println("Description:");
        for (String line : newPattern.getDescription()) {
            System.out.println(line);
        }

        System.out.println(System.lineSeparator());
        System.out.println("Pattern Rows:");
        for (String line : newPattern.getPatternRows()) {
            System.out.println(line);
        }

        System.out.println(System.lineSeparator());
        System.out.println(System.lineSeparator() + "Are you ready to upload to the database?");
        String input = helper.getUserInput("Type 'Y' to upload or type 'N' to make more changes: ");
        if (input.equals("Y") || input.equals("y")) {
            return false; // upload pattern
        } else {
            return true; // go back to construction
        }
    }


}
