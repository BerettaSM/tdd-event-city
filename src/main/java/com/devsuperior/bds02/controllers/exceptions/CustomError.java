package com.devsuperior.bds02.controllers.exceptions;

import java.time.Instant;

import com.devsuperior.bds02.exceptions.ApplicationException;

public class CustomError {

    private String message;
    private Integer status;
    private Instant timestamp;
    private String path;

    public CustomError() {
    }

    public CustomError(String message, Integer status, Instant timestamp, String path) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.path = path;
    }

    public CustomError(ApplicationException e) {
        message = e.getMessage();
        status = e.geHttpStatusCode();
        timestamp = Instant.now();
        path = e.getPath();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static CustomError from(ApplicationException e) {
        return new CustomError(e);
    }

}
