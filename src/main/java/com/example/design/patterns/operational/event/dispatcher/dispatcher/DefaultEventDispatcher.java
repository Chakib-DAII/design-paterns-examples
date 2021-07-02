package com.example.design.patterns.operational.event.dispatcher.dispatcher;

import com.example.design.patterns.operational.event.dispatcher.event.Event;
import com.example.design.patterns.operational.event.dispatcher.listener.EventListener;
import com.example.design.patterns.operational.event.dispatcher.type.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by chakib.daii on 7/1/2021.
 */
@Component
public class DefaultEventDispatcher implements EventDispatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultEventDispatcher.class);

    protected List<EventListener> eventListeners;
    protected Map<EventType, List<EventListener>> typedListeners;
    protected boolean enabled = true;

    public DefaultEventDispatcher() {
        eventListeners = new CopyOnWriteArrayList<>();
        typedListeners = new HashMap<>();
    }

    @Override
    public void addEventListener(EventListener listenerToAdd) {
        if (listenerToAdd == null) {
            throw new IllegalArgumentException("Listener cannot be null.");
        }
        Collection<? extends EventType> types = listenerToAdd.getTypes();
        if (types.isEmpty()) {
            if (!eventListeners.contains(listenerToAdd)) {
                eventListeners.add(listenerToAdd);
            }
        } else {
            for (EventType type : types) {
                addTypedEventListener(listenerToAdd, type);
            }
        }
    }

    @Override
    public void addEventListener(EventListener listenerToAdd, EventType... types) {
        if (listenerToAdd == null) {
            throw new IllegalArgumentException("Listener cannot be null.");
        }

        if (types == null || types.length == 0) {
            addEventListener(listenerToAdd);

        } else {
            for (EventType type : types) {
                addTypedEventListener(listenerToAdd, type);
            }
        }
    }

    @Override
    public void removeEventListener(EventListener listenerToRemove) {
        eventListeners.remove(listenerToRemove);

        for (List<EventListener> listeners : typedListeners.values()) {
            listeners.remove(listenerToRemove);
        }
    }

    @Override
    public void dispatchEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null.");
        }

        if (event.getType() == null) {
            throw new IllegalArgumentException("Event type cannot be null.");
        }

        // Call global listeners
        if (!eventListeners.isEmpty()) {
            for (EventListener listener : eventListeners) {
                dispatchEvent(event, listener);
            }
        }

        // Call typed listeners, if any
        List<EventListener> typed = typedListeners.get(event.getType());
        if (typed != null && !typed.isEmpty()) {
            for (EventListener listener : typed) {
                dispatchEvent(event, listener);
            }
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    protected synchronized void addTypedEventListener(EventListener listener, EventType type) {
        List<EventListener> listeners = typedListeners.get(type);
        if (listeners == null) {
            // Add an empty list of listeners for this type
            listeners = new CopyOnWriteArrayList<>();
            typedListeners.put(type, listeners);
        }

        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    protected void dispatchEvent(Event event, EventListener listener) {
        try {
            listener.onEvent(event);
        } catch (Throwable t) {
            if (listener.isFailOnException()) {
                throw t;
            } else {
                // Ignore the exception and continue notifying remaining listeners. The listener
                // explicitly states that the exception should not bubble up
                LOGGER.warn("Exception while executing event-listener, which was ignored", t);
            }
        }
    }

    public List<EventListener> getEventListeners() {
        return eventListeners;
    }

    public Map<EventType, List<EventListener>> getTypedListeners() {
        return typedListeners;
    }
}
