package com.example.design.patterns.operational.publish.subscribe.custom.generic;

import com.example.design.patterns.operational.publish.subscribe.custom.OurCustomEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by chakib.daii on 3/21/2021.
 */
@Component
public class GenericSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(Object event, boolean success) {
        System.out.println("Publishing generic event. ");
        GenericSpringEvent<?> customSpringEvent = new GenericSpringEvent(event, success);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
