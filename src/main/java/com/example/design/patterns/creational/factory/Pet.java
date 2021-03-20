package com.example.design.patterns.creational.factory;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public interface Pet {
    void setName(String name);
    String getName();
    String getType();
    boolean isHungry();
    void feed();
}
