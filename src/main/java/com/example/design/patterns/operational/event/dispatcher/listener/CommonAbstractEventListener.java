package com.example.design.patterns.operational.event.dispatcher.listener;

import com.example.design.patterns.operational.event.dispatcher.event.Event;
import com.example.design.patterns.operational.event.dispatcher.event.PersistenceEvent;
import com.example.design.patterns.operational.event.dispatcher.event.RuntimeEvent;
import com.example.design.patterns.operational.event.dispatcher.type.EventType;
import com.example.design.patterns.operational.event.dispatcher.type.PersistenceEventType;
import com.example.design.patterns.operational.event.dispatcher.type.RuntimeEventType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by chakib.daii on 7/1/2021.
 */
public abstract class CommonAbstractEventListener extends AbstractEventListener{
    protected Set<EventType> types;
    protected List<Event> eventsReceived;

    protected CommonAbstractEventListener() {
    }

    protected CommonAbstractEventListener(Set<EventType> types) {
        this.types = types;
        this.eventsReceived = new ArrayList<>();
    }

    @Override
    public final void onEvent(Event event) {
            if(event instanceof PersistenceEvent){
                PersistenceEvent persistenceEvent = (PersistenceEvent) event;
                PersistenceEventType persistenceEventType = (PersistenceEventType) persistenceEvent.getType();
//                Object persistenceEventEntity = persistenceEvent.getEntity();

                if (types == null || types.contains(persistenceEventType)) {
                    switch (persistenceEventType) {
                        case ENTITY_CREATED : entityCreated(persistenceEvent); break;
                        case ENTITY_INITIALIZED : entityInitialized(persistenceEvent); break;
                        case ENTITY_ACTIVATED : entityActivated(persistenceEvent); break;
                        case ENTITY_UPDATED : entityUpdated(persistenceEvent); break;
                        case ENTITY_SUSPENDED : entitySuspended(persistenceEvent);break;
                        case ENTITY_DELETED : entityDeleted(persistenceEvent); break;
                        default: throw new IllegalArgumentException();
                    }
                }
            }
            else if(event instanceof RuntimeEvent){
                RuntimeEvent runtimeEvent = (RuntimeEvent) event;
                RuntimeEventType runtimeEventType = (RuntimeEventType) runtimeEvent.getType();
//                String runtimeEventExecution = runtimeEvent.getExecutionId();

                if (types == null || types.contains(runtimeEventType)) {
                    switch (runtimeEventType) {
                        case ENGINE_CREATED : engineCreated(runtimeEvent); break;
                        case ENGINE_CLOSED :engineClosed(runtimeEvent); break;
                        case JOB_SCHEDULED : jobScheduled(runtimeEvent); break;
                        case JOB_CANCELED : jobCancelled(runtimeEvent); break;
                        case JOB_EXECUTION_SUCCESS : jobExecutionSuccess(runtimeEvent); break;
                        case JOB_EXECUTION_FAILURE : jobExecutionFailure(runtimeEvent); break;
                        case JOB_RETRIES_DECREMENTED : jobRetriesDecremented(runtimeEvent); break;
                        case JOB_REJECTED : jobRejected(runtimeEvent); break;
                        case JOB_RESCHEDULED : jobRescheduled(runtimeEvent); break;
                        case JOB_MOVED_TO_DEAD_LETTER : break;
                        case CUSTOM : custom(runtimeEvent); break;
                        default: throw new IllegalArgumentException();
                    }
                }
            }
    }

    @Override
    public boolean isFailOnException() {
        return true;
    }

    @Override
    public Collection<? extends EventType> getTypes() {
        return types == null ? super.getTypes() : types;
    }

//    protected Execution getExecution(RuntimeEvent event) {
//        String executionId = event.getExecutionId();
//
//        if (executionId != null) {
//            CommandContext commandContext = CommandContextUtil.getCommandContext();
//            if (commandContext != null) {
//                return CommandContextUtil.getExecutionEntityManager(commandContext).findById(executionId);
//            }
//        }
//        return null;
//    }


    public List<Event> getEventsReceived() {
        return eventsReceived;
    }

    public void clearEventsReceived() {
        eventsReceived.clear();
    }

    protected void entityCreated(PersistenceEvent event){
        throw new UnsupportedOperationException();
    }

    protected void entityInitialized(PersistenceEvent event){
        throw new UnsupportedOperationException();
    }

    protected void entityUpdated(PersistenceEvent event){
        throw new UnsupportedOperationException();
    }

    protected void entityDeleted(PersistenceEvent event){
        throw new UnsupportedOperationException();
    }

    protected void entitySuspended(PersistenceEvent event){
        throw new UnsupportedOperationException();
    }

    protected void entityActivated(PersistenceEvent event){
        throw new UnsupportedOperationException();
    }

    protected void jobCancelled(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

    protected void jobExecutionSuccess(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

    protected void jobExecutionFailure(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

    protected void jobRetriesDecremented(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

    protected void jobScheduled(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

    protected void jobRescheduled(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

    protected void jobRejected(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

    protected void custom(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

    protected void engineCreated(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

    protected void engineClosed(RuntimeEvent event){
        throw new UnsupportedOperationException();
    }

}
