package com.example.design.patterns.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by chakib.daii on 3/20/2021.
 */
@Slf4j
@ControllerAdvice
public class TestControllerHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(UnsupportedOperationException.class)
    public void handleBadRequest(UnsupportedOperationException ex) {
        log.error("Invalid account supplied in request");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler(Exception.class)
    public void handleGeneralError(Exception ex) {
        log.error("An error occurred processing request" + ex);
    }
}
