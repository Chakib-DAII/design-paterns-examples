package com.example.design.patterns.operational.publish.subscribe.custom.generic;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

/**
 * Created by chakib.daii on 3/21/2021.
 */
@Component
public class AnnotationDrivenGenericSpringEventListener {

    @EventListener(condition = "#event.success")
    public void handleSuccess(GenericSpringEvent<?> event) {
        out.println("Received spring generic event - succeeded \n"
                + event.getEvent().getClass().getName() +"\n" + event.getEvent().toString());
    }
    @EventListener(condition = "#event.success == false")
    public void handleFailure(GenericSpringEvent<?> event) {
        out.println("Received spring generic event - failed \n"
                + event.getEvent().getClass().getName() +"\n"+ event.getEvent().toString());
    }
}
