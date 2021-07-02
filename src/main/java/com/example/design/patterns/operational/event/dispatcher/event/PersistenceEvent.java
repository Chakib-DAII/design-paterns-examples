package com.example.design.patterns.operational.event.dispatcher.event;

/**
 * Describes a persistence event that occurred which is dispatched to external listeners, if any.
 *
 * Created by chakib.daii on 7/1/2021.
 */
public interface PersistenceEvent extends Event {

    /**
     * @return the entity that is targeted by this event.
     */
    Object getEntity();
}
