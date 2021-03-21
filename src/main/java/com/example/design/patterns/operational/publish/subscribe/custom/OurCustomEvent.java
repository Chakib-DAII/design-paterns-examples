package com.example.design.patterns.operational.publish.subscribe.custom;

import org.springframework.context.ApplicationEvent;

/**
 * Created by chakib.daii on 3/21/2021.
 */
public class OurCustomEvent extends ApplicationEvent {
    private String message;

    public OurCustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    @Override
    public String toString() {
        return "OurCustomEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
