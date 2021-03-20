package com.example.design.patterns.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by chakib.daii on 3/20/2021.
 */
@Slf4j
public class RealExpensiveObjectImpl implements RealExpensiveObject{

    public RealExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }

    @Override
    public void process() {
        log.info("processing complete.");
    }

    private void heavyInitialConfiguration() {
        log.info("Loading initial configuration...");
    }
}
