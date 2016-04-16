package com.patternpartner;

import java.util.*;

/**
 * Command line app for testing errors throughout the code
 * @author Sebastian Greenholtz
 */
public class ErrorTester {

    public static void main(String[] args) {
        ViewPattern viewer = new ViewPattern();
        Pattern pat = viewer.getPattern(4);
        System.out.println(pat);

    }
}
