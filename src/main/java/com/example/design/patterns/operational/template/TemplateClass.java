package com.example.design.patterns.operational.template;

import org.springframework.web.client.RestTemplate;

/**
 * Created by chakib.daii on 3/20/2021.
 */
public abstract class TemplateClass {
    public String open(){
        return getClass().getSimpleName() + " : opened";
    }

    public abstract void performWork();

    public void close(){
        System.out.println(getClass().getSimpleName() + " : closed");
    }
}
