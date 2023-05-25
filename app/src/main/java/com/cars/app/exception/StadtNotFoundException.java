package com.cars.app.exception;

public class StadtNotFoundException extends RuntimeException{
    public StadtNotFoundException(String message) {
        super(message);
    }
}
