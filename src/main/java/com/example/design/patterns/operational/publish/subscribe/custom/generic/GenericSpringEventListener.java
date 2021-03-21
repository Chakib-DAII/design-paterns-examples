package com.example.design.patterns.operational.publish.subscribe.custom.generic;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by chakib.daii on 3/21/2021.
 */
@Component
public class GenericSpringEventListener implements ApplicationListener<GenericSpringEvent<?>>{
    @Override
    public void onApplicationEvent(GenericSpringEvent<?> event) {
        System.out.println("Received spring generic event - " + event.getEvent().toString());
    }
}
