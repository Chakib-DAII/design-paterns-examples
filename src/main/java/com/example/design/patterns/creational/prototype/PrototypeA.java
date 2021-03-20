package com.example.design.patterns.creational.prototype;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public class PrototypeA implements Cloneable{
    private int a;
    private int b;


    public PrototypeA(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
