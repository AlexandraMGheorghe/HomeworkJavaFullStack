package com.example.homework16.exception;

public class MismatchedPasswordException extends RuntimeException{
    public MismatchedPasswordException(String message) {
        super(message);
    }
}
