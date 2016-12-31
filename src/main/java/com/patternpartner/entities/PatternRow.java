package com.patternpartner.entities;

/**
 * A row of pattern text
 * @author Sebastian Greenholtz
 */
public class PatternRow extends Row {

    private boolean isActiveRow;
    private Image image;

    public PatternRow(String rowText) {
        super(rowText);
    }

    public boolean getIsActiveRow() {
        return isActiveRow;
    }

    public void setIsActiveRow(boolean isActive) {
        this.isActiveRow = isActive;
    }
}
