package com.patternpartner;

import java.util.*;

/**
 * This class allows the user to preview the pattern and make changes before sending the pattern to the database.
 * <br />
 * Methods set the title, materials, and description lines to add to database.
 * @author Sebatian Greenholtz
 */
public class PatternPreview {

    static String LINE_SEPARATOR = System.lineSeparator();

    private String title;
    private ArrayList<String> lines;
    private ArrayList<String> lineClass;

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public ArrayList<String> getLineClass() {
        return lineClass;
    }

    /**
     * Sets the lines array list instance variable, then instantiates the
     * lineClass array list to be of the same length as lines
     * @param lines list to assign to the instance variable
     */
    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
        lineClass = new ArrayList<>();
        for (String line : lines) {
            lineClass.add("");
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Methods

    @Override
    public String toString() {
        String output = "";
        for (String line : lines) {
            output += line + LINE_SEPARATOR;
        }
        return output;
    }
}
