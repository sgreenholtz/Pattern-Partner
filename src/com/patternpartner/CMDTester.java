package com.patternpartner;

/**
 * This class tests the CMDHelper Class
 * Created by Kolya on 2016-01-31.
 */
public class CMDTester {
    public static void main(String[] args) {
        CMDHelper helper = new CMDHelper();

        String answer = helper.getUserInput("Enter a number: ");
        System.out.println(answer);
    }
}