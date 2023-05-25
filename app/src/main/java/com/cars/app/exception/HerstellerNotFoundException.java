package com.cars.app.exception;

public class HerstellerNotFoundException extends RuntimeException{
    public HerstellerNotFoundException(String message) {
        super(message);
    }
}