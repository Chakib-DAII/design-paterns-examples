package com.example.design.patterns.structural.adapter;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public class AppleAdapter implements Apple{
    private final Orange orange;

    public AppleAdapter(Orange orange) {
        this.orange = orange;
    }

    @Override
    public String getVariety() {
        return orange.getVariety();
    }

    @Override
    public void eat() {
        orange.peal();
        orange.eat();
    }
}
