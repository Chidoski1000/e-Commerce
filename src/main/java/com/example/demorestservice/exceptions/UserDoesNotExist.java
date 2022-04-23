package com.example.demorestservice.exceptions;

public class UserDoesNotExist extends RuntimeException{
    public UserDoesNotExist(String message) {
        super(message);
    }

    public UserDoesNotExist() {
    }
}
