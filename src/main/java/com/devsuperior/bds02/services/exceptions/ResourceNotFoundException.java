package com.devsuperior.bds02.services.exceptions;

import org.springframework.http.HttpStatus;

import com.devsuperior.bds02.exceptions.ApplicationException;

public class ResourceNotFoundException extends ApplicationException {

    private static final HttpStatus DEFAULT_STATUS = HttpStatus.NOT_FOUND;

    public ResourceNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }

    public ResourceNotFoundException(String message) {
        this(message, DEFAULT_STATUS);
    }

    public ResourceNotFoundException(HttpStatus status) {
        this("Resource not found.", status);
    }

    public ResourceNotFoundException() {
        this(DEFAULT_STATUS);
    }

}
