package com.patternpartner.entities.materials;

/**
 * Represents a crochet hook
 * @author Sebastian Greenholtz
 */
public class CrochetHook extends Material {

    private CrochetHookSizes size;
    private CrochetHookTypes type;

    public CrochetHook() {
    }

    public CrochetHook(CrochetHookSizes size, CrochetHookTypes type) {
        this.size = size;
        this.type = type;
    }

    public CrochetHookSizes getSize() {
        return size;
    }

    public void setSize(CrochetHookSizes size) {
        this.size = size;
    }

    public CrochetHookTypes getType() {
        return type;
    }

    public void setType(CrochetHookTypes type) {
        this.type = type;
    }
}
