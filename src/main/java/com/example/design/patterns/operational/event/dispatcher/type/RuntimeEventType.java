package com.example.design.patterns.operational.event.dispatcher.type;

/**
 * Created by chakib.daii on 7/1/2021.
 */
public enum RuntimeEventType implements EventType {

    /**
     * The process-engine that dispatched this event has been created and is ready for use.
     */
    ENGINE_CREATED,

    /**
     * The process-engine that dispatched this event has been closed and cannot be used anymore.
     */
    ENGINE_CLOSED,

    /**
     * A Timer has been scheduled.
     */
    JOB_SCHEDULED,

    /**
     * Timer has been cancelled (e.g. user task on which it was bounded has been completed earlier than expected)
     */
    JOB_CANCELED,

    /**
     * A job has been successfully executed.
     */
    JOB_EXECUTION_SUCCESS,

    /**
     * A job has been executed, but failed. Event should be an instance of a ExceptionEvent.
     */
    JOB_EXECUTION_FAILURE,

    /**
     * The retry-count on a job has been decremented.
     */
    JOB_RETRIES_DECREMENTED,

    /**
     * A job has been rejected by the async executor. This most likely means the queue is full.
     */
    JOB_REJECTED,

    /**
     * The job has been rescheduled.
     */
    JOB_RESCHEDULED,

    /**
     * A job has been moved to become a deadletter job. This typically means that the number of retries have been exhausted.
     */
    JOB_MOVED_TO_DEAD_LETTER,

    /**
     * An event type to be used by custom events. These types of events are never thrown by the engine itself, only be an external API call to dispatch an event.
     */
    CUSTOM
}
