package com.example.design.patterns.operational.event.dispatcher.listener;

/**
 * Created by chakib.daii on 7/1/2021.
 */
public abstract class AbstractEventListener implements EventListener {
    protected String onTransaction;
    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return onTransaction != null;
    }

    @Override
    public String getOnTransaction() {
        return onTransaction;
    }

    public void setOnTransaction(String onTransaction) {
        this.onTransaction = onTransaction;
    }
}
