package com.patternpartner;
import java.io.*;

/**
 * This class is responsible for getting the file choice from the user and
 * setting information about the file.
 *
 * TO DO : add additional fields other than name
 *
 * Created by Kolya on 2016-01-31.
 */
public class NewPattern {

    private CMDHelper helper = new CMDHelper();
    private String path;
    private String name;
    private String rowDelimiter;

    /**
     * This is the no argument constructor
     */
    public NewPattern() {
        path = chooseInputFile();
        name = chooseName();
        rowDelimiter = chooseRowDelimiter();
    }

    /**
     * Gets the values for path
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets the values for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the value for rowDelimiter
     * @return rowDelimiter
     */
    public String getRowDelimiter() {
        return rowDelimiter;
    }

    /**
     * This method asks the user for a file to process. Works best with full path of the file.
     * @returns inputPath The path of the file to add
     */
    public String chooseInputFile() {
        System.out.println("Tip: If your file is not in the same directory, include a full path.");
        String inputPath = helper.getUserInput("What file would you like to add?");

        return "lib/" + inputPath;
    }

    /**
     * This method asks the user what they want to name the pattern
     * @return fileName the name of the pattern
     */
    public String chooseName() {
        String fileName = helper.getUserInput("What do you want to name the pattern?");

        return fileName;
    }

    /**
     * This method asks the user what word is used to delimit rows
     * @return delimiter the word used for rows
     */
    public String chooseRowDelimiter() {
        System.out.println("What word is used to mark off rows?");
        String delimiter = helper.getUserInput("For example, \"row\", \"round\", numbers: ");

        return delimiter;
    }

    /**
     * This method prints out a human readable string about the pattern
     * @return display the string to display
     */
    public String toString() {
        String display = "Pattern Name: " + name + System.lineSeparator() + "File Path: " + path;
        return display;
    }


}
