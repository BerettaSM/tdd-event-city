package com.devsuperior.bds02.exceptions;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

public class ApplicationException extends RuntimeException {

    protected final HttpStatus httpStatus;
    protected final String path;
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public ApplicationException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        httpStatus = status;
        path = getCurrentPath();
    }

    public ApplicationException(String message, Throwable cause) {
        this(message, cause, DEFAULT_STATUS);
    }

    public ApplicationException(String message, HttpStatus status) {
        this(message, null, status);
    }

    public ApplicationException(Throwable cause, HttpStatus status) {
        this("Something went wrong.", cause, status);
    }

    public ApplicationException(String message) {
        this(message, (Throwable) null);
    }

    public ApplicationException(Throwable cause) {
        this(cause, DEFAULT_STATUS);
    }

    public ApplicationException(HttpStatus status) {
        this((Throwable) null, status);
    }

    public ApplicationException() {
        this(DEFAULT_STATUS);
    }

    public HttpStatus geHttpStatus() {
        return httpStatus;
    }

    public int geHttpStatusCode() {
        return httpStatus.value();
    }

    public String getPath() {
        return path;
    }

    protected final static String getCurrentPath() {
        return Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                .map(req -> ((ServletRequestAttributes) req))
                .map(ServletRequestAttributes::getRequest)
                .map(HttpServletRequest::getRequestURI)
                .orElse("Unknown path");
    }

}
