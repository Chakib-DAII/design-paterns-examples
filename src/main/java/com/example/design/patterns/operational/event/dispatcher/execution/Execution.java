package com.example.design.patterns.operational.event.dispatcher.execution;

import com.example.design.patterns.operational.event.dispatcher.event.RuntimeEvent;

/**
 * Created by chakib.daii on 7/1/2021.
 */
public interface Execution extends RuntimeEvent {
    Class<?> getClazz() throws ClassNotFoundException;
    String getExpression();
    String getDelegateExpression();
}
