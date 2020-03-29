package com.market.app.exception;

public class BusinessAlreadyExistException extends Exception {
    public BusinessAlreadyExistException() {
        super();
    }

    public BusinessAlreadyExistException(String message) {
        super(message);
    }

    public BusinessAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
