package com.cars.app.exception;

public class AusstattungNotFoundException extends RuntimeException{

    public AusstattungNotFoundException(String message) {
        super(message);
    }
}