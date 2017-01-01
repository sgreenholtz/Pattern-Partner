package com.patternpartner.entities.images;

/**
 * Image saved to the local image server
 * @author Sebastian Greenholtz
 */
public class LocalImage extends Image {

    private String license;

    public LocalImage(String url) {
        super(url);
    }

    //TODO: implement code to pull from local image server
}
