/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.design.patterns.operational.event.dispatcher.listener;

import com.example.design.patterns.operational.event.dispatcher.event.Event;
import com.example.design.patterns.operational.event.dispatcher.type.EventType;

import java.util.Collection;
import java.util.Collections;

/**
 * Describes a class that listens for {@link Event}s dispatched by the engine.
 *
 * Created by chakib.daii on 7/1/2021.
 *
 */
public interface EventListener {

    /**
     * Called when an event has been fired
     * 
     * @param event the event
     */
    void onEvent(Event event);

    /**
     * @return whether or not the current operation should fail when this listeners execution throws an exception.
     */
    boolean isFailOnException();
    
    /**
     * @return Returns whether this event listener fires immediately when the event occurs or 
     *         on a transaction lifecycle event (before/after commit or rollback).
     */
    boolean isFireOnTransactionLifecycleEvent();
    
    /**
     * @return if non-null, indicates the point in the lifecycle of the current transaction when the event should be fired.
     */
    String getOnTransaction();
    
    /**
     * The event types that this event listener needs to be registered for
     *
     * @return the specific event types that this listeners should register itself for
     */
    default Collection<? extends EventType> getTypes() {
        return Collections.emptySet();
    }

}
