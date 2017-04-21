package com.patternpartner.entities;

/**
 * @author Sebastian Greenholtz
 */
public abstract class Row {

    private String rowText;

    public Row(String rowText) {
        this.rowText = rowText;
    }

    public String getRowText() {
        return rowText;
    }
}
