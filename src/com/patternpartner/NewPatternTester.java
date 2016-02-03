package com.patternpartner;

/**
 * This class tests the NewPattern class
 * Created by Kolya on 2016-02-02.
 */
public class NewPatternTester {

    public static void main(String[] args) {
        AddNewLine demo = new AddNewLine();
        demo.setPattern();


        PatternPreview preview = new PatternPreview();
        preview.showPattern("lib/" + demo.addNewLine());

        CMDHelper helper = new CMDHelper();
        String input = "";

        while (!(input.equals("q"))) {
            System.out.println("What line would you like to add a record separator to?");
            input = helper.getUserInput("Type 'q' to quit: ");

            if (!(input.equals("q"))) {
                Integer index = Integer.parseInt(input);
                preview.addRecordSeparatorToLine(index);
            }
        }
    }

}
