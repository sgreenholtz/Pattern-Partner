package com.patternpartner.entities;
import java.util.*;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * This class represents a pattern. Patterns are read into the program from files, so the processing goes by line. The
 * Pattern object handles the line reading through ArrayList instance variables to hold each line of the text.
 * <br />
 * Method listToString creates a single String for the parts of the pattern that will not be saved as individual lines
 * in the database, materials and description.
 * <br />
 * Getters and Setters have been added to allow usage of Pattern as a bean
 * <br />
 * TO DO : implement image handling
 *
 * @author Sebastian Greenholtz
 */
public class Pattern {

    private String name;
    private ArrayList<String> description;
    private ArrayList<Material> materials;
    private ArrayList<PatternRow> patternRows;
    private PatternType patternType;
    // private Image image;

    /**
     * No arg constructor, initiates ArrayLists
     */
    public Pattern() {
        description = new ArrayList<>();
        materials = new ArrayList<>();
        patternRows = new ArrayList<>();
    }

    /**
     * Converts array lists to a single string with a space delimiter
     * @param list ArrayList to convert to string
     * @return completed string
     */
    public String listToString(ArrayList<String> list) {
        String output = "";
        for (String line : list) {
            line = StringEscapeUtils.escapeEcmaScript(line);
            output += line + " ";
        }
        return output;
    }
}
