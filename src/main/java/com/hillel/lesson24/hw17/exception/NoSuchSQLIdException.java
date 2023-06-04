package com.hillel.lesson24.hw17.exception;

public class NoSuchSQLIdException extends RuntimeException {
    public NoSuchSQLIdException(String message) {
        super(message);
    }
}
