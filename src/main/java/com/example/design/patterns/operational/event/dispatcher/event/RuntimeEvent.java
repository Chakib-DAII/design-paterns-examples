package com.example.design.patterns.operational.event.dispatcher.event;

import java.util.StringJoiner;

/**
 * Describes a runtime event that occurred which is dispatched to external listeners, if any.
 *
 * Created by chakib.daii on 7/1/2021.
 */
public interface RuntimeEvent extends Event {

    /**
     * @return the execution that is targeted by this event.
     */
    String getExecutionId();
}
