package com.example.demorestservice.exceptions;

public class PasswordMismatchException extends RuntimeException{
    public PasswordMismatchException(String message) {
        super(message);
    }

    public PasswordMismatchException() {
    }
}
