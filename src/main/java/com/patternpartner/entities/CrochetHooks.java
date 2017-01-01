package com.patternpartner.entities;

/**
 * Enum of common crochet hook sizes. The Enum values are the US letter values,
 * with the millimeter value available as a double.
 * <p>Based on <a href="http://www.craftyarncouncil.com/hooks.html">Craft Yarn Council - Hook Sizes</a></p>
 * @author Sebastian Greenholtz
 */
public enum CrochetHooks {
    B(2.25),
    C(2.75),
    D(3.25),
    E(3.5),
    F(3.75),
    G(4),
    H(5),
    I(5.5),
    J(6),
    K(6.5),
    L(8),
    MN(9),
    NP(10),
    PQ(15),
    Q(16),
    S(19);

    private final double millimeterMeasure;

    CrochetHooks(double mm) {
        this.millimeterMeasure = mm;
    }

    double getMillimeterMeasure() {
        return millimeterMeasure;
    }
}
