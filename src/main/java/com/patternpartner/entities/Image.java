package com.patternpartner.entities;

/**
 * An image embedded either in a specific pattern row or assigned to the pattern as a whole.
 * Actual images are served from an image server or pulled from the internet via url
 * at runtime
 * @author Sebastian Greenholtz
 */
public abstract class Image {

    private String url;

    public Image(String url) {
        this.url = url;
    }
}
