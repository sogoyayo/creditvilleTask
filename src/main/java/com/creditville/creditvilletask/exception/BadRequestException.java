package com.creditville.creditvilletask.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public BadRequestException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BadRequestException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
