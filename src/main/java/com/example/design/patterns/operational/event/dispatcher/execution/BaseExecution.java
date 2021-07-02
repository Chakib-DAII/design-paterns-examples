package com.example.design.patterns.operational.event.dispatcher.execution;

import com.example.design.patterns.operational.event.dispatcher.type.EventType;

/**
 * Created by chakib.daii on 7/1/2021.
 */
public class BaseExecution implements Execution{
    protected String executionId;
    protected EventType eventType;
    protected String clazz;
    protected String expression;
    protected String delegateExpression;

    public void setDelegateExpression(String delegateExpression) {
        this.delegateExpression = "${" + delegateExpression + "}";
    }

    public void setExpression(String expression) {
        if (expression != null)
            this.expression = "${" + expression + "}";
    }

    @Override
    public Class<?> getClazz() throws ClassNotFoundException {
        return Class.forName(clazz);
    }

    @Override
    public String getExpression() {
        return expression;
    }

    @Override
    public String getDelegateExpression() {
        return delegateExpression;
    }

    @Override
    public String getExecutionId() {
        return executionId;
    }

    @Override
    public EventType getType() {
        return eventType;
    }
}
