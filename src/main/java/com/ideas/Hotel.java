package com.ideas;

import java.util.List;
import java.util.Objects;

public class Hotel {
    private final List<Rate> rates;
    private final String name;

    public Hotel(List<Rate> rates, String name) {
        this.rates = rates;
        this.name = name;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRates(), name);
    }
}