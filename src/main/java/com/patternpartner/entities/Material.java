package com.patternpartner.entities;

/**
 * Represents some kind of material for a pattern
 * @author Sebastian Greenholtz
 */
public abstract class Material {

    private String name;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
