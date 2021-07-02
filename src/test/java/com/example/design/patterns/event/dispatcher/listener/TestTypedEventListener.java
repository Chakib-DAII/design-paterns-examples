package com.example.design.patterns.event.dispatcher.listener;

import com.example.design.patterns.operational.event.dispatcher.event.RuntimeEvent;
import com.example.design.patterns.operational.event.dispatcher.listener.CommonAbstractEventListener;
import com.example.design.patterns.operational.publish.subscribe.custom.generic.GenericSpringEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;

import static com.example.design.patterns.operational.event.dispatcher.type.RuntimeEventType.*;

/**
 * Created by chakib.daii on 7/2/2021.
 */
public class TestTypedEventListener extends CommonAbstractEventListener {

    public TestTypedEventListener(){
        super(new HashSet<>(Arrays.asList(ENGINE_CREATED, ENGINE_CLOSED, CUSTOM)));
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    @Override
    protected void custom(RuntimeEvent event) {
        eventsReceived.add(event);
        //event handling logic
    }

    @Override
    protected void engineCreated(RuntimeEvent event) {
        eventsReceived.add(event);
        //event handling logic
    }

    @Override
    protected void engineClosed(RuntimeEvent event) {
        eventsReceived.add(event);
        //event handling logic
    }
}
