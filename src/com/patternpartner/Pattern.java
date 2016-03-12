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
    private String knitOrCrochet;
    // private Image image;

    /**
     * No arg constructor, initiates ArrayLists
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
                   ArrayList<String> materialList, ArrayList<String> rowList, String kOrC) {
        this.name = name;
        description = descriptionList;
        materials = materialList;
        patternRows = rowList;
        knitOrCrochet = kOrC;
    }

    /**
     * Gets the values for name
     * @return name with quotation marks around it for single quote preservation
     */
    public String getName() {
        return "\"" + name + "\"";
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
     * Gets the values for knitOrCrochet
     * @return knitOrCrochet
     */
    public String getKnitOrCrochet() { return knitOrCrochet; }

    /**
     * Converts array lists to a single string with a space delimiter
     * @param list ArrayList to convert to string
     * @return completed string
     */
    public String listToString(ArrayList<String> list) {
        String output = "";
        for (String line : list) {
            line = line.replaceAll("%", "\"");
            line = line.replaceAll("'", "\'");
            output += line + " ";
        }
        output = "'" + output + "'";
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
