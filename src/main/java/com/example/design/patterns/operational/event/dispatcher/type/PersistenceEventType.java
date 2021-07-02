package com.example.design.patterns.operational.event.dispatcher.type;

/**
 * Created by chakib.daii on 7/1/2021.
 */
public enum PersistenceEventType implements EventType {
    /**
     * New entity is created.
     */
    ENTITY_CREATED,

    /**
     * New entity has been created and all properties have been set.
     */
    ENTITY_INITIALIZED,

    /**
     * Existing entity us updated.
     */
    ENTITY_UPDATED,

    /**
     * Existing entity is deleted.
     */
    ENTITY_DELETED,

    /**
     * Existing entity has been suspended.
     */
    ENTITY_SUSPENDED,

    /**
     * Existing entity has been activated.
     */
    ENTITY_ACTIVATED
}
