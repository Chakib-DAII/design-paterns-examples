package com.example.design.patterns.aspect;

import static java.lang.System.out;

/**
 * Created by chakib.daii on 5/5/2021.
 */
public aspect World {

    pointcut greeting() : execution ( Hello.sayHello(..) );

    after() returning() : greeting() {
        out.println("World ");

    }

    before() : greeting() {
        out.println("World ");
    }

}
