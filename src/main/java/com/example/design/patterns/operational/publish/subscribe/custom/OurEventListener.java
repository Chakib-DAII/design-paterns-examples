package com.example.design.patterns.operational.publish.subscribe.custom;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

/**
 * Created by chakib.daii on 3/21/2021.
 */
@Component
public class OurEventListener implements ApplicationListener<OurCustomEvent> {
    @Override
    public void onApplicationEvent(OurCustomEvent event) {
        out.println("ApplicationListener : Spring custom event received : \n" + event.toString());
    }
}
