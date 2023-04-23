package com.example.homework16.exception;

public class LogUserResponseEntityExceptionHandler extends RuntimeException {
    public LogUserResponseEntityExceptionHandler(String message) {
        super(message);
    }
}
