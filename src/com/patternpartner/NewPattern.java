package com.patternpartner;
import java.io.*;

/**
 * This class is responsible for getting the file choice from the user and
 * creating a new file based on inputted file name from user.
 *
 * Created by Kolya on 2016-01-31.
 */
public class NewPattern {

    private CMDHelper helper = new CMDHelper();
    private String path;
    private String name;

    /**
     * This method runs the file choice menu
     */
    public void run() {
        chooseInputFile();
        chooseName();
    }

    /**
     * This method asks the user for a file to process. Works best with full path of the file.
     * @returns inputPath The path of the file to add
     */
    public String chooseInputFile() {
        System.out.println("Tip: If your file is not in the same directory, include a full path.");
        String inputPath = helper.getUserInput("What file would you like to add?");

        return inputPath;
    }

    /**
     * This method asks the user what they want to name the pattern
     * @return fileName the name of the pattern
     */
    public String chooseName() {
        String fileName = helper.getUserInput("What do you want to name the pattern?");

        return fileName;
    }

}
