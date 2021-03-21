package com.example.design.patterns.operational.publish.subscribe.custom;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

/**
 * Created by chakib.daii on 3/21/2021.
 */
@Component
public class OurSecondEventListener {
    @EventListener
    public void handleEvent(OurCustomEvent event){
        out.println("@EventListener : Spring custom event received : \n" + event.toString());
    }
}
