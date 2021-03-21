package com.example.design.patterns.operational.publish.subscribe.custom;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import static java.lang.System.*;

/**
 * Created by chakib.daii on 3/21/2021.
 */
@Component
public class OurEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(final String message) {
        out.println("Publishing our custom event. ");
        OurCustomEvent customSpringEvent = new OurCustomEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

}
