package com.appliation.rmis.exception;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String userNotFound) {
        super(userNotFound);
    }
}
