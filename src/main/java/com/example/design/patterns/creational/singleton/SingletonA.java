package com.example.design.patterns.creational.singleton;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public class SingletonA {
    private static SingletonA instance;

    private SingletonA() {
        super();
    }

    public static SingletonA getInstance() {
        if(instance == null){
            synchronized (SingletonA.class){
                if(instance == null)
                    instance = new SingletonA();
            }
        }
        return instance;
    }
}
