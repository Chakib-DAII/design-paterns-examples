package com.example.design.patterns.operational.publish.subscribe.custom.generic;

import org.springframework.context.ApplicationEvent;

/**
 * Created by chakib.daii on 3/21/2021.
 */
public class GenericSpringEvent<T> extends ApplicationEvent {
    private T event;
    protected boolean success;

    public GenericSpringEvent(T event, boolean success) {
        super(event);
        this.event = event;
        this.success = success;
    }

    public T getEvent() {
        return event;
    }

    public void setEvent(T event) {
        this.event = event;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
