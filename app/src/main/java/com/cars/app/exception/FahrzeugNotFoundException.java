package com.cars.app.exception;

public class FahrzeugNotFoundException extends RuntimeException{
    public FahrzeugNotFoundException(String message) {
        super(message);
    }
}
