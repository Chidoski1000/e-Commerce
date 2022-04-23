package com.example.demorestservice.exceptions;

public class IncorrectCredentialsException extends RuntimeException{
    public IncorrectCredentialsException() {
    }

    public IncorrectCredentialsException(String message) {
        super(message);
    }
}
