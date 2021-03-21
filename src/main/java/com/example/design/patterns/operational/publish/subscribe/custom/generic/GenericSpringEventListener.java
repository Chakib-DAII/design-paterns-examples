package com.example.design.patterns.operational.publish.subscribe.custom.generic;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

/**
 * Created by chakib.daii on 3/21/2021.
 */
@Component
public class GenericSpringEventListener implements ApplicationListener<GenericSpringEvent<?>>{
    @Override
    public void onApplicationEvent(GenericSpringEvent<?> event) {
        out.println("Received spring generic event - " + event.getEvent().toString());
    }
}
