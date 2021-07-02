package com.example.design.patterns.operational.event.dispatcher.exception;

import com.example.design.patterns.operational.event.dispatcher.event.RuntimeEvent;
import com.example.design.patterns.operational.event.dispatcher.type.EventType;

/**
 * Created by chakib.daii on 7/1/2021.
 */
public class CommonRuntimeExceptionEvent extends CommonExceptionEvent implements RuntimeEvent {
    protected String executionId;

    public CommonRuntimeExceptionEvent(Throwable cause, EventType eventType, String executionId) {
        super(cause, eventType);
        if (executionId == null || "".equals(executionId)) {
            throw new IllegalArgumentException("Execution cannot be null.");
        }
        this.executionId = executionId;
    }

    @Override
    public String getExecutionId() {
        return executionId;
    }

    public void setExecution(String execution) {
        this.executionId = execution;
    }
}
