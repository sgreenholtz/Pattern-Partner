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
    private ArrayList<String> lineClass;
    private CMDHelper helper = new CMDHelper();


    // Getters and Setters

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
        for (int i=0; i<lines.size(); i++) {
            lineClass.add(i, "");
        }
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

        for (String line : lines) {
            System.out.println(lineCount + ". " + line);
            lineCount++;
        }
        System.out.println(System.lineSeparator());
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
