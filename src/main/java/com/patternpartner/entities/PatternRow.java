package com.patternpartner.entities;

/**
 * A row of pattern text
 * @author Sebastian Greenholtz
 */
public class PatternRow extends Row {

    private boolean isActiveRow;
    private Image image;
    private int imageLocation;

    public PatternRow(String rowText) {
        super(rowText);
    }

    public boolean getIsActiveRow() {
        return isActiveRow;
    }

    public void setIsActiveRow(boolean isActive) {
        this.isActiveRow = isActive;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(int imageLocation) {
        this.imageLocation = imageLocation;
    }
}
