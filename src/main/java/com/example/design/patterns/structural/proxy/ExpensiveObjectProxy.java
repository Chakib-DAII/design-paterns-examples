package com.example.design.patterns.structural.proxy;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public class ExpensiveObjectProxy implements RealExpensiveObject{
    private static RealExpensiveObject realObject;

    @Override
    public void process() {
        if (realObject == null)
            realObject = new RealExpensiveObjectImpl();
        realObject.process();
    }
}
