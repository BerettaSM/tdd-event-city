package com.devsuperior.bds02.services.exceptions;

import org.springframework.http.HttpStatus;

import com.devsuperior.bds02.exceptions.ApplicationException;

public class DatabaseException extends ApplicationException {
    
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.BAD_REQUEST;

    public DatabaseException(String message, HttpStatus status) {
        super(message, status);
    }

    public DatabaseException(String message) {
        this(message, DEFAULT_STATUS);
    }

    public DatabaseException(HttpStatus status) {
        this("Exception on database.", status);
    }

    public DatabaseException() {
        this(DEFAULT_STATUS);
    }

}
