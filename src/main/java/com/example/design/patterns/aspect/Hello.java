package com.example.design.patterns.aspect;

/**
 * Created by chakib.daii on 5/5/2021.
 */
import static java.lang.System.out;
public class Hello {

    public static void main(String[] args){
        sayHello();
        sayHello("Red");
    }

    public static void sayHello(){
        out.println("Hello ");
    }

    public static void sayHello(String name){
        out.println("Hello "+name);
    }
}
