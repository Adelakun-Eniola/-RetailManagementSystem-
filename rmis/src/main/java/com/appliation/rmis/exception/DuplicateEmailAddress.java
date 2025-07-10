package com.appliation.rmis.exception;

public class DuplicateEmailAddress extends RuntimeException{
    public DuplicateEmailAddress(String message){
        super(message);
    }
}
