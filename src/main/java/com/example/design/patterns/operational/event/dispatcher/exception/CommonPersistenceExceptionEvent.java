package com.example.design.patterns.operational.event.dispatcher.exception;

import com.example.design.patterns.operational.event.dispatcher.type.EventType;
import com.example.design.patterns.operational.event.dispatcher.event.PersistenceEvent;

/**
 * Created by chakib.daii on 7/1/2021.
 */
public class CommonPersistenceExceptionEvent extends CommonExceptionEvent implements PersistenceEvent {
    protected Object entity;

    public CommonPersistenceExceptionEvent(Throwable cause, EventType eventType, Object entity) {
        super(cause, eventType);
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null.");
        }
        this.entity = entity;
    }

    @Override
    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }
}
