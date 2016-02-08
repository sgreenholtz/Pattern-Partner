package com.patternpartner;

/**
 * This class runs the part of the program to add a new pattern.
 * Created by Kolya on 2016-02-07.
 */
public class AddNewPattern {

    /**
     * This method runs through the user input needed to process
     * a new pattern
     */
    public void addNewPattern() {
        AddNewLine processor = new AddNewLine();
        processor.setPattern();

        PatternPreview preview = new PatternPreview("lib/" + processor.addNewLine());
        preview.editLineSeparators();
    }
}
