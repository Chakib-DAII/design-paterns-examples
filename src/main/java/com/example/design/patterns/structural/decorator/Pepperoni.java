package com.example.design.patterns.structural.decorator;

import java.math.BigDecimal;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public class Pepperoni extends PizzaIngredient {
    private Pizza pizza;

    public Pepperoni(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " + pepperoni";
    }

    @Override
    public BigDecimal getCost() {
        return (new BigDecimal(1.5).add(this.pizza.getCost()));
    }
}
