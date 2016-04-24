package com.patternpartner;
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
    private ArrayList<String> materials;
    private ArrayList<String> patternRows;
    private ArrayList<Boolean> isActiveRow;
    private String knitOrCrochet;
    private ArrayList<Integer> repeatCount;
    // private Image image;

    /**
     * No arg constructor, initiates ArrayLists
     */
    public Pattern() {
        description = new ArrayList<String>();
        materials = new ArrayList<String>();
        patternRows = new ArrayList<String>();
        isActiveRow = new ArrayList<Boolean>();
    }

    /**
     * Constructor sets each of the instance variables
     */
    public Pattern(String name, ArrayList<String> descriptionList,
                   ArrayList<String> materialList, ArrayList<String> rowList,
                   String kOrC) {
        this.name = name;
        description = descriptionList;
        materials = materialList;
        patternRows = rowList;
        knitOrCrochet = kOrC;
    }

    /**
     * Sets only the part of the pattern needed for reading the pattern:
     * description, materials, pattern rows, is Active and repeat count
     */
    public Pattern(String name,
                   String description,
                   ArrayList<String> materials,
                   ArrayList<String> patternRows,
                   ArrayList<Boolean> isActiveRow,
                   ArrayList<Integer> repeatCount) {
        this.name = name;
        this.description = new ArrayList<String>();
        this.description.add(description);
        this.materials = materials;
        this.patternRows = patternRows;
        this.isActiveRow = isActiveRow;
        this.repeatCount = repeatCount;
    }

    /**
     * Gets the values for name
     * @return name with quotation marks around it for single quote preservation
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
     * Gets the values for knitOrCrochet
     * @return knitOrCrochet
     */
    public String getKnitOrCrochet() { return knitOrCrochet; }

    /**
     * Gets the values for isActiveRow
     * @return isActiveRow
     */
    public ArrayList<Boolean> getIsActiveRow() {
        return isActiveRow;
    }

    /**
     * Sets name to given value
     *
     * @param name value to set instance variable to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets description to given value
     *
     * @param description value to set instance variable to
     */
    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    /**
     * Sets materials to given value
     *
     * @param materials value to set instance variable to
     */
    public void setMaterials(ArrayList<String> materials) {
        this.materials = materials;
    }

    /**
     * Sets patternRows to given value
     *
     * @param patternRows value to set instance variable to
     */
    public void setPatternRows(ArrayList<String> patternRows) {
        this.patternRows = patternRows;
    }

    /**
     * Sets isActiveRow to given value
     *
     * @param isActiveRow value to set instance variable to
     */
    public void setIsActiveRow(ArrayList<Boolean> isActiveRow) {
        this.isActiveRow = isActiveRow;
    }

    /**
     * Sets knitOrCrochet to given value
     *
     * @param knitOrCrochet value to set instance variable to
     */
    public void setKnitOrCrochet(String knitOrCrochet) {
        this.knitOrCrochet = knitOrCrochet;
    }

    /**
     * Gets the value of repeatCount.
     *
     * @return repeatCount
     */
    public ArrayList<Integer> getRepeatCount() {
        return repeatCount;
    }

    /**
     * Sets repeatCount to given value
     *
     * @param repeatCount value to set instance variable to
     */
    public void setRepeatCount(ArrayList<Integer> repeatCount) {
        this.repeatCount = repeatCount;
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

    /**
     * Outputs human readable information about pattern
     * @return Name of pattern
     */
    @Override
    public String toString() {
        return "Pattern{" +
                "name='" + name + '\'' +
                ", description=" + description +
                ", materials=" + materials +
                ", patternRows=" + patternRows +
                '}';
    }
}
