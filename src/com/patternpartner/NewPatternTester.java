package com.patternpartner;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * This class tests the NewPattern class
 * @author Sebastian Greenholtz
 */
public class NewPatternTester {

    public static void main(String[] args) {
        UserVerification verify = new UserVerification();
        verify.login();

        AddNewPattern demo = new AddNewPattern();
    }

}