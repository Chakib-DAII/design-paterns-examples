package com.example.design.patterns.api;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CustomMethodArgumentNotValidException handleValidationError(MethodArgumentNotValidException ex){
        return new CustomMethodArgumentNotValidException(ex.getMessage(), ex.getFieldErrors());
    }

    public static class CustomMethodArgumentNotValidException extends RuntimeException{
        private List<CustomFieldError> customFieldErrors;

        public CustomMethodArgumentNotValidException(String message,
            List<FieldError> fieldErrorList) {
            super(message);
            fieldErrorList.forEach( fe -> add(fe.getObjectName(), fe.getField(), fe.getCode()));
        }

        public void add(String objectName, String field, String message){
             if(this.customFieldErrors == null)
                 this.customFieldErrors = new ArrayList<>();
              this.customFieldErrors.add(new CustomFieldError(objectName, field, message));
        }

        public List<CustomFieldError> getCustomFieldErrors() {
            return customFieldErrors;
        }

        public static class CustomFieldError{
            private final String objectName;
            private final String field;
            private final String code;

            public CustomFieldError(String objectName, String field, String code) {
                this.objectName = objectName;
                this.field = field;
                this.code = code;
            }

            public String getObjectName() {
                return objectName;
            }

            public String getField() {
                return field;
            }

            public String getCode() {
                return code;
            }
        }
    }
}
