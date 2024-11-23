package com.example.oms.advice;

import com.example.oms.dao.DefaultError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExcepetionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<DefaultError> handleConflict(
            RuntimeException ex, WebRequest request) {
        DefaultError defaultError = new DefaultError();
        defaultError.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(defaultError, HttpStatus.BAD_REQUEST);
    }
}
