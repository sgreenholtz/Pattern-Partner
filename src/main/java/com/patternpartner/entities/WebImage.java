package com.patternpartner.entities;

/**
 * An image from the web, hosted on someone else's server
 * @author Sebastian Greenholtz
 */
public class WebImage extends Image {

    private String license;

    public WebImage(String url) {
        super(url);
    }

    //TODO: Implement method to get the image from the interwebz
}
