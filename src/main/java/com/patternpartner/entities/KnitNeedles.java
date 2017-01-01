package com.patternpartner.entities;

/**
 * Enum for common knitting needle sizes. The Enum values are the US names spelled out,
 * with the millimeter value available as a double.
 * <p>Based on <a href="http://www.craftyarncouncil.com/hooks.html">Craft Yarn Council - Hook Sizes</a></p>
 * @author Sebastian Greenholtz
 */
public enum KnitNeedles {
    ONE(2.25),
    TWO(2.75),
    THREE(3.25),
    FOUR(3.5),
    FIVE(3.75),
    SIX(4),
    SEVEN(4.5),
    EIGHT(5),
    NINE(5.5),
    TEN(6),
    TENHALF(6.5),
    ELEVEN(8),
    THIRTEEN(9),
    FIFTEEN(10),
    SEVENTEEN(12.75),
    NINETEEN(15),
    THIRTYFIVE(19);

    private final double millimeterMeasure;

    KnitNeedles(double mm) {
        this.millimeterMeasure = mm;
    }

    double getMillimeterMeasure() {
        return millimeterMeasure;
    }

}
