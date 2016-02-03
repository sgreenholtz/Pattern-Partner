package com.patternpartner;
import java.io.*;

/**
 * This class reads through a file and adds a new line before the word "row"
 * Created by Kolya on 2016-01-31.
 */
public class AddNewLine {

    static String NEW_LINE = System.lineSeparator();
    private NewPattern pattern;

    /**
     * This method writes the new file with new line characters
     */
    public void writeNewFile() {

    }

    /**
     * This method sets the instance variable pattern.
     */
    public void setPattern() {
        pattern = new NewPattern();
    }

    /**
     * This method reads through the file and adds a new line whenever it sees the word "row"
     * @return
     */
    public String addNewLine() {
        String line = null;
        String newLine = null;

        try (BufferedReader in = new BufferedReader(new FileReader(pattern.getPath())))

    }
}
