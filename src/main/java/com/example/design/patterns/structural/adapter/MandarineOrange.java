package com.example.design.patterns.structural.adapter;

import static java.lang.System.out;
/**
 * Created by chakib.daii on 3/20/2021.
 */
public class MandarineOrange implements Orange{
    @Override
    public String getVariety() {
        return "Mandarine";
    }

    @Override
    public void eat() {
        out.println("Mandarine gets enjoyed!");
    }

    @Override
    public void peal() {
        out.println("Mandarine gets pealed!");
    }

    @Override
    public void juice() {
        out.println("Mandarine gets juiced!");
    }
}
