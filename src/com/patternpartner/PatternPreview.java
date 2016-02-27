package com.patternpartner;
import javax.servlet.http.HttpServlet;
import java.util.*;

/**
 * This class allows the user to preview the pattern and make changes before sending the pattern to the database.
 * <br />
 * Methods set the title, materials, and description lines to add to database.
 * @author Sebatian Greenholtz
 * @see <a href="AddNewPattern.html">AddNewPattern</a>
 */
public class PatternPreview extends HttpServlet {

    static char RECORD_SEPARATOR = '\u241E';
    static String LINE_SEPARATOR = System.lineSeparator();

    private String title;
    private ArrayList<String> lines;
    private CMDHelper helper = new CMDHelper();

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Methods

    /**
     * This method displays the entire pattern as formatted on the command line,
     * with line numbers to help with adding additional record separator symbols
     */
    public void showPattern() {
        int lineCount = 0;

        System.out.println(System.lineSeparator());
        for (String line : lines) {
            System.out.println(lineCount + ". " + line);
            lineCount++;
        }
        System.out.println(System.lineSeparator());
    }

    /**
     * This method shows the pattern and asks the user to add record separator, adds it, then shows
     * the pattern again, until the user enters the quit symbol.
     */
    public void editLineSeparators() {
        String input = "";

        while (!(input.equals("q"))) {
            showPattern();
            System.out.println(LINE_SEPARATOR + "What line would you like to add a record separator to?");
            input = helper.getUserInput("Type 'q' to finish: ");

            if (!(input.equals("q"))) {
                Integer index = Integer.parseInt(input);
                addRecordSeparatorToLine(index);
                System.out.println(LINE_SEPARATOR);
            }
        }
    }

    /**
     * This method adds a record separator symbol before the line specified
     * @param index index of the line to add the record separator symbol to
     */
    public void addRecordSeparatorToLine(int index) {
        String line = lines.get(index);
        String newLine = RECORD_SEPARATOR + line;
        lines.remove(index);
        lines.add(index, newLine);
    }

    /**
     * Uses record separators from lines to create an array list of pattern rows. For use with constructPattern in
     * AddNewPattern
     * @return ArrayList of pattern rows
     */
    public ArrayList<String> setRows() {
        ArrayList<String> rows = new ArrayList<String>();
        for (String line : lines) {
            if (line.startsWith(String.valueOf(RECORD_SEPARATOR))) {
                rows.add(line);
            }
        }
        return rows;
    }

    /**
     * Asks user what line represents the title and returns the value of that line as the name variable. If there is not
     * one line that represents the title, user can type in a string to use for name. For use with constructPattern in
     * AddNewPattern
     * @return title of the pattern
     */
    public String setName() {
        String output = "";
        String input = "";
        showPattern();

        System.out.println("Which line represents the TITLE of the pattern?");
        input = helper.getUserInput("Type line number or a name for the pattern: ");

        if (input.matches("\\d+")) {
            Integer lineNum = new Integer(input);
            if (testNullPointer(lineNum)) {
                output = lines.get(lineNum);
            } else {
                setName();
            }
        } else {
            output = input;
        }

        return output;
    }

    /**
     * Asks user if the pattern is a knit or crochet pattern and returns either "k" for knit or "c" for crochet.
     * For use with constructPattern in AddNewPattern
     * @return knit "k" or crochet "c"
     */
    public String setKnitOrCrochet() {
        String input = helper.getUserInput("Is this a knit or crochet pattern? ");

        if (input.equals("knit") || input.equals("k")) {
            input = "k";
        } else if (input.equals("crochet") || input.equals("c")) {
            input = "c";
        } else {
            System.out.println("That is not a valid answer.");
            setKnitOrCrochet();
        }
        return input;
    }

    /**
     * Asks user what line represents the start line and end line for the materials section returns an ArrayList with
     * the lines for the materials section. For use with constructPattern in AddNewPattern
     * @return ArrayList of materials section rows of the pattern
     */
    public ArrayList<String> setMaterials() {
        ArrayList<String> output = new ArrayList<String>();

        showPattern();

        String start = helper.getUserInput("What line is the start of the materials section?: ");
        String end = helper.getUserInput("What line is the end of the materials section?: ");

        if (start.matches("\\d+") && end.matches("\\d+")) {
            Integer intStart = new Integer(start);
            Integer intEnd = new Integer(end);
            if (testNullPointer(intStart) && testNullPointer(intEnd)) {
                if (intStart == intEnd) {
                    output.add(lines.get(intStart));
                } else {
                    int lineCounter = intStart;
                    while (lineCounter <= intEnd) {
                        output.add(lines.get(lineCounter));
                        lineCounter++;
                    }
                }
            } else {
                setMaterials();
            }
        } else {
            System.out.println("That is not a valid line number.");
        }

        return output;
    }

    /**
     * Asks user what line represents the start line and end line for the description section returns an ArrayList with
     * the lines for the description section. For use with constructPattern in AddNewPattern
     * @return ArrayList of description section rows of the pattern
     */
    public ArrayList<String> setDescription(){
        ArrayList<String> output = new ArrayList<String>();

        showPattern();

        String start = helper.getUserInput("What line is the start of the description section?: ");
        String end = helper.getUserInput("What line is the end of the description section?: ");

        if (start.matches("\\d+") && end.matches("\\d+")) {
            Integer intStart = new Integer(start);
            Integer intEnd = new Integer(end);
            if (testNullPointer(intStart) && testNullPointer(intEnd)) {
                if (intStart == intEnd) {
                    output.add(lines.get(intStart));
                } else {
                    int lineCounter = intStart;
                    while (lineCounter <= intEnd) {
                        output.add(lines.get(lineCounter));
                        lineCounter++;
                    }
                }
            } else {
                setMaterials();
            }
        } else {
            System.out.println("That is not a valid line number.");
        }

        return output;
    }

    /**
     * Tests whether the line number entered is an actual line in the list
     * @param lineNum line number to test
     * @return true/false for pass/fail
     */
    public boolean testNullPointer(Integer lineNum) {
        if (lineNum > lines.size()-1) {
            System.out.println("That is not a valid line number.");
            return false;
        } else if (lineNum < 0) {
            System.out.println("You can't have a negative line number!");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (String line : lines) {
            output += line + LINE_SEPARATOR;
        }
        return output;
    }
}
