package com.example.design.patterns.structural.decorator;

import java.math.BigDecimal;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public abstract class Pizza {
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract BigDecimal getCost();
}
