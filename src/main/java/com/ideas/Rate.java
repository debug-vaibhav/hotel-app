package com.ideas;

import com.ideas.enums.RateType;

public class Rate {
    private double value;
    private final RateType type;

    public Rate(double value, RateType type) {
        this.value = value;
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public RateType getType() {
        return type;
    }
}
