package com.hillel.lesson24.hw17.exception;

public class UnsuccessfulUpdateException extends RuntimeException {
    public UnsuccessfulUpdateException(String message) {
        super(message);
    }
}
