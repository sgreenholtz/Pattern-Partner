package com.patternpartner;

/**
 * This class facilitates the adding of a new pattern
 * Created by Kolya on 2016-02-07.
 */
public class AddNewPattern {

    private CMDHelper helper = new CMDHelper();
    private String path;
    private String rowDelimiter;

    /**
     * This is the no argument constructor
     */
    public AddNewPattern() {
        path = setInputFile();
        rowDelimiter = setRowDelimiter();
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
        System.out.println("Tip: If your file is not in the same directory, include a full path.");
        String inputPath = helper.getUserInput("What file would you like to add?");

        return "lib/" + inputPath;
    }

    /**
     *
     * @return newPattern Pattern with pieces processed
     */
    public Pattern processPattern() {
        Pattern newPattern = new Pattern();

        return newPattern;
    }

}
