package com.patternpartner;

import com.patternpartner.entities.Pattern;

import java.util.*;

/**
 * This class allows the user to preview the pattern and make changes before sending the pattern to the database.
 * <br />
 * Methods set the title, materials, and description lines to add to database.
 * @author Sebatian Greenholtz
 */
public class PatternPreview {

    private static Properties PROPERTIES;
    private String title;
    private String knitOrCrochet;
    private ArrayList<String> lines;
    private ArrayList<String> lineClass;

    // Constructor

    /**
     * Set up properties
     */
    public PatternPreview() {
        LoadProperties propLoader = new LoadProperties();
        PROPERTIES = propLoader.loadProperties("patternpreview.properties");
    }

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
        setLineClass();
    }

    /**
     * Instantiates lineClass to blank values, or to row
     * highlight value if the row starts with "row" or "round"
     */
    private void setLineClass() {
        lineClass = new ArrayList<String>();
        for (String line : lines) {
            if (line.toLowerCase().startsWith("row") ||
                    line.toLowerCase().startsWith("round")) {
                lineClass.add("warning");
            } else {
                lineClass.add("");
            }
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKnitOrCrochet(String knitOrCrochet) {
        this.knitOrCrochet = knitOrCrochet;
    }

    // Methods

    /**
     * Creates a new ArrayList to represent each section of the pattern
     * @param className the class associated with a particular color of line
     *                  preview
     * @return new ArrayList with the specified lines
     */
    public ArrayList<String> createSectionArrayList(String className) {
        ArrayList<String> newList = new ArrayList<String>();
        for (int i = 0; i<lines.size(); i++) {
            if (lineClass.get(i).equals(className)) {
                newList.add(lines.get(i));
            }
        }
        return newList;
    }

    /**
     * Creates a Pattern object from the array lists of description, materials and rows,
     * plus title and knitOrCrochet letter saves as instance variables
     * @return new Pattern object
     */
    public Pattern constructPattern(ArrayList<String> description, ArrayList<String> materials,
                                    ArrayList<String> rows) {
        return new Pattern(title, description, materials, rows, knitOrCrochet);
    }

    @Override
    public String toString() {
        String output = "";
        for (String line : lines) {
            output += line + "\n";
        }
        return output;
    }
}
