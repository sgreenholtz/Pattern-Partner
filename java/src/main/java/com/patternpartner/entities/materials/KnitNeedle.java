package com.patternpartner.entities.materials;

/**
 * Represents a knitting needle
 * @author Sebastian Greenholtz
 */
public class KnitNeedle extends Material {
    private KnitNeedleSizes size;
    private KnitNeedleTypes type;

    public KnitNeedle() {
    }

    public KnitNeedle(KnitNeedleSizes size, KnitNeedleTypes type) {
        this.size = size;
        this.type = type;
    }

    public KnitNeedleSizes getSize() {
        return size;
    }

    public void setSize(KnitNeedleSizes size) {
        this.size = size;
    }

    public KnitNeedleTypes getType() {
        return type;
    }

    public void setType(KnitNeedleTypes type) {
        this.type = type;
    }
}
