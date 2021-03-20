package com.example.design.patterns.structural.decorator;

import java.math.BigDecimal;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public class ThickCrustPizza extends Pizza{

    public ThickCrustPizza() {
        super();
        this.description = "Thick Crust Pizza";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15.00);
    }
}
