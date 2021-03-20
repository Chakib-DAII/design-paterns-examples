package com.example.design.patterns.creational.factory.types;

import com.example.design.patterns.creational.factory.Pet;
import com.example.design.patterns.creational.factory.enumeration.PetType;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public class Cat implements Pet {
    private String name;
    private boolean hungry = true;
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return PetType.CAT.name();
    }

    @Override
    public boolean isHungry() {
        return this.hungry;
    }

    @Override
    public void feed() {
        this.hungry = false;
    }
}
