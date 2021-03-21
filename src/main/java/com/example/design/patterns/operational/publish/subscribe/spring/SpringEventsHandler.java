package com.example.design.patterns.operational.publish.subscribe.spring;

import org.springframework.boot.BootstrapContextClosedEvent;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.context.event.*;
import org.springframework.boot.rsocket.context.RSocketServerInitializedEvent;
import org.springframework.boot.web.reactive.context.ReactiveWebServerInitializedEvent;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import static java.lang.System.out;

/**
 * Created by chakib.daii on 3/21/2021.
 */
@Component
public class SpringEventsHandler {

    @EventListener
    public void handleAnyApplicationEvent(ApplicationEvent event){
        out.println("SpringEventsHandler : ApplicationEvent received : \n" + event.toString());
    }

    //ApplicationContextEvent events (Spring context)
    @EventListener
    public void handleAnyApplicationContextEvent(ApplicationContextEvent event){
        out.println("SpringEventsHandler : ApplicationContextEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleContextStartedEvent(ContextStartedEvent event){
        out.println("SpringEventsHandler : ContextStartedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleContextRefreshedEvent(ContextRefreshedEvent event){//2
        out.println("SpringEventsHandler : ContextRefreshedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleContextStoppedEvent(ContextStoppedEvent event){
        out.println("SpringEventsHandler : ContextStoppedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleContextClosedEvent(ContextClosedEvent event){
        out.println("SpringEventsHandler : ContextClosedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handlePayloadApplicationEvent(PayloadApplicationEvent<?> event){//4
        out.println("SpringEventsHandler : PayloadApplicationEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleExitCodeEvent(ExitCodeEvent event){
        out.println("SpringEventsHandler : ExitCodeEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleServletRequestHandledEvent(ServletRequestHandledEvent event){// when servlet request (rest)
        out.println("SpringEventsHandler : ServletRequestHandledEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleRequestHandledEvent(RequestHandledEvent event){
        out.println("SpringEventsHandler : ExitCodeEvent received : \n" + event.toString());
    }

    //SpringApplicationEvent events (Spring boot context events )

    @EventListener
    public void handleAnySpringApplicationEvent(SpringApplicationEvent event){
        out.println("SpringEventsHandler : SpringApplicationEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleApplicationContextInitializedEvent(ApplicationContextInitializedEvent event){
        out.println("SpringEventsHandler : ApplicationContextInitializedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleApplicationEnvironmentPreparedEvent(ApplicationEnvironmentPreparedEvent event){
        out.println("SpringEventsHandler : ApplicationEnvironmentPreparedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleApplicationFailedEvent(ApplicationFailedEvent event){
        out.println("SpringEventsHandler : ApplicationFailedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleApplicationPreparedEvent(ApplicationPreparedEvent event){
        out.println("SpringEventsHandler : ApplicationPreparedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleApplicationReadyEvent(ApplicationReadyEvent event){//6
        out.println("SpringEventsHandler : ApplicationReadyEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleApplicationStartedEvent(ApplicationStartedEvent event){//3
        out.println("SpringEventsHandler : ApplicationStartedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleApplicationStartingEvent(ApplicationStartingEvent event){
        out.println("SpringEventsHandler : ApplicationStartingEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleAvailabilityChangeEvent(AvailabilityChangeEvent<? extends AvailabilityState> event){//5
        out.println("SpringEventsHandler : AvailabilityChangeEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleBootstrapContextClosedEvent(BootstrapContextClosedEvent event){
        out.println("SpringEventsHandler : BootstrapContextClosedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleServletWebServerInitializedEvent(ServletWebServerInitializedEvent event){//1
        out.println("SpringEventsHandler : ServletWebServerInitializedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleRSocketServerInitializedEvent(RSocketServerInitializedEvent event){
        out.println("SpringEventsHandler : RSocketServerInitializedEvent received : \n" + event.toString());
    }

    @EventListener
    public void handleReactiveWebServerInitializedEvent(ReactiveWebServerInitializedEvent event){
        out.println("SpringEventsHandler : ReactiveWebServerInitializedEvent received : \n" + event.toString());
    }



}
