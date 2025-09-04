package com.devsuperior.bds02.controllers.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.exceptions.ApplicationException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Void> catchAll(ApplicationException e) {
        return ResponseEntity.status(e.geHttpStatusCode()).build();
    }
    
}
