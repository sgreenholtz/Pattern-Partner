package com.patternpartner;
import java.io.*;

/**
 * This class gets arguments from the user on the command line and feeds them back as strings into the program.
 * Based on class InputHelper from eknapp
 * Created by Kolya on 2016-01-31.
 */
public class CMDHelper {
    /**
     *  Gets the userInput attribute
     *  of the InputHelper object
     *
     *@param  prompt  The prompt seen by the user
     *@return         The userInput value
     */
    public String getUserInput(String prompt) {
        String  inputLine  = null;
        System.out.print(prompt + "  ");
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            inputLine = input.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return inputLine;
    }
}
