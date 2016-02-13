package com.patternpartner;
import java.util.*;

/**
 * This class represents a pattern
 *
 * TO DO : implement image handling
 *
 * Created by Kolya on 2016-01-31.
 */
public class Pattern {

    private String name;
    private ArrayList<String> description;
    private ArrayList<String> materials;
    private ArrayList<String> patternRows;
    // private Image image;

    /**
     * No arg constructor, intiates ArrayLists
     */
    public Pattern() {
        description = new ArrayList<String>();
        materials = new ArrayList<String>();
        patternRows = new ArrayList<String>();
    }

    /**
     * Gets the values for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the values for description
     * @return name
     */
    public ArrayList<String> getDescription() {
        return description;
    }

    /**
     * Gets the values for materials
     * @return name
     */
    public ArrayList<String> getMaterials() {
        return materials;
    }

    /**
     * Gets the values for patternRows
     * @return name
     */
    public ArrayList<String> getPatternRows() {
        return patternRows;
    }

    /**
     * Sets value of patternRows
     * @param patternRows value to set as patternRows
     * @return patternRows
     */
    public Pattern setPatternRows(ArrayList<String> patternRows) {
        this.patternRows = patternRows;
        return this;
    }

    /**
     * Sets value of name
     * @param name value to set as name
     * @return name
     */
    public Pattern setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets value of description
     * @param description value to set as description
     * @return description
     */
    public Pattern setDescription(ArrayList<String> description) {
        this.description = description;
        return this;
    }

    /**
     * Sets value of materials
     * @param materials value to set as materials
     * @return materials
     */
    public Pattern setMaterials(ArrayList<String> materials) {
        this.materials = materials;
        return this;
    }

    /**
     * Converts array lists to a single string with a space delimiter
     * @param list ArrayList to convert to string
     * @return completed string
     */
    public String listToString(ArrayList<String> list) {
        String output = null;
        for (String line : list) {
            output += line + " ";
        }
        return output;
    }

    /**
     * Outputs human readable information about pattern
     * @return Name of pattern
     */
    public String toString() {
        return "Name: " + name;
    }
}
