package com.patternpartner.entities.yarns;

import com.patternpartner.entities.materials.Material;

/**
 * A kind of yarn
 * @author Sebastian Greenholtz
 */
public class Yarn extends Material {
    private String color;
    private YarnAmount amount;
    private YarnWeight weight;
    private String fiber;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public YarnAmount getAmount() {
        return amount;
    }

    public void setAmount(YarnAmount amount) {
        this.amount = amount;
    }

    public YarnWeight getWeight() {
        return weight;
    }

    public void setWeight(YarnWeight weight) {
        this.weight = weight;
    }

    public String getFiber() {
        return fiber;
    }

    public void setFiber(String fiber) {
        this.fiber = fiber;
    }
}
