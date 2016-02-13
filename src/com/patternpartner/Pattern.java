package com.patternpartner;
import java.util.*;

/**
 * This class represents a pattern. Patterns are read into the program from files, so the processing goes by line. The
 * Pattern object handles the line reading through ArrayList instance variables to hold each line of the text.
 * <br />
 * Method listToString creates a single String for the parts of the pattern that will not be saved as individual lines
 * in the database, materials and description.
 * <br />
 * TO DO : implement image handling
 *
 * @author Sebastian Greenholtz
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
     * Constructor sets each of the instance variables
     */
    public Pattern(String name, ArrayList<String> descriptionList,
                   ArrayList<String> materialList, ArrayList<String> rowList) {
        this.name = name;
        description = descriptionList;
        materials = materialList;
        patternRows = rowList;
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
     * Adds value to patternRows
     * @param row value to add to patternRows
     */
    public void setPatternRows(String row) {
        patternRows.add(row);
    }

    /**
     * Sets value of name
     * @param name value to set as name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds value to description
     * @param descriptionRow value to add to description
     */
    public void setDescription(String descriptionRow) {
        description.add(descriptionRow);
    }

    /**
     * Adds value to materials
     * @param materialRow value to set as materials
     */
    public void setMaterials(String materialRow) {
        materials.add(materialRow);
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
