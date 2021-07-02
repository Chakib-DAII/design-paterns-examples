package com.example.design.patterns.event.dispatcher.event;

import com.example.design.patterns.operational.event.dispatcher.event.RuntimeEvent;
import com.example.design.patterns.operational.event.dispatcher.type.EventType;

import java.util.StringJoiner;
import java.util.UUID;

import static com.example.design.patterns.operational.event.dispatcher.type.RuntimeEventType.CUSTOM;

/**
 * Created by chakib.daii on 7/2/2021.
 */
public class CustomEngineEvent implements RuntimeEvent {

    @Override
    public String getExecutionId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public EventType getType() {
        return CUSTOM;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomEngineEvent.class.getSimpleName() + "[", "]")
                .add(getExecutionId())
                .add(getType().name())
                .toString();
    }
}
