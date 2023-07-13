package com.sebastian.arrays;

public class EmptyArrayException extends RuntimeException {

    public EmptyArrayException(String message) {
        super(message);
    }

    public EmptyArrayException() {
        super();
    }
}// class
