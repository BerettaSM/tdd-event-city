package com.devsuperior.bds02.controllers.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.controllers.exceptions.CustomError;
import com.devsuperior.bds02.exceptions.ApplicationException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<CustomError> catchAll(ApplicationException e) {
        CustomError err = CustomError.from(e);
        return ResponseEntity.status(err.getStatus()).body(err);
    }
    
}
