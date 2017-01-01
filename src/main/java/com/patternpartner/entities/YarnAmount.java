package com.patternpartner.entities;

/**
 * Specifies a double value for the amount and an enum for the unit
 * @author Sebastian Greenholtz
 */
public class YarnAmount {

    private double amount;
    private YarnAmountUnit unit;

    public YarnAmount() {}

    public YarnAmount(double amount, YarnAmountUnit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public YarnAmountUnit getUnit() {
        return unit;
    }

    public void setUnit(YarnAmountUnit unit) {
        this.unit = unit;
    }
}
