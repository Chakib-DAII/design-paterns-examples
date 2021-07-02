package com.example.design.patterns.operational.event.dispatcher.exception;

import com.example.design.patterns.operational.event.dispatcher.event.Event;
import com.example.design.patterns.operational.event.dispatcher.type.EventType;
import com.example.design.patterns.operational.event.dispatcher.type.PersistenceEventType;

/**
 * Created by chakib.daii on 7/1/2021.
 */
public class CommonExceptionEvent implements ExceptionEvent, Event {
    protected Throwable cause;
    protected EventType eventType;

    public CommonExceptionEvent(Throwable cause, EventType eventType) {
        this.cause = cause;
        this.eventType = eventType;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    @Override
    public EventType getType() {
        return eventType;
    }
}
