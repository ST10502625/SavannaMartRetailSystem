package com.mycompany.savannamartretailsystem.exception;

/**
 * Custom checked exception thrown when order data is invalid.
 */
public class InvalidOrderException extends Exception {

    public InvalidOrderException(String message) {
        super(message);
    }
}