package com.landlordassistant.application.exceptionHandling;

public class NoSuchPeriodException extends NoSuchEntityException{
    public NoSuchPeriodException(String message) {
        super(message);
    }
}
