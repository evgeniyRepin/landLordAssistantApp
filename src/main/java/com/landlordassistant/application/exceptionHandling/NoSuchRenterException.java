package com.landlordassistant.application.exceptionHandling;

public class NoSuchRenterException extends NoSuchEntityException {
    public NoSuchRenterException(String message) {
        super(message);
    }
}
