package com.example.design.patterns.event.dispatcher.listener;

import com.example.design.patterns.operational.event.dispatcher.listener.CommonAbstractEventListener;

/**
 * Created by chakib.daii on 7/2/2021.
 */
public class TestGlobalEventListener  extends CommonAbstractEventListener {

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
