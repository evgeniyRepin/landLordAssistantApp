package com.landlordassistant.application.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectInfoMassage> handleException(NoSuchEntityException exception) {
        IncorrectInfoMassage incorrectInfoMassage = new IncorrectInfoMassage();
        incorrectInfoMassage.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectInfoMassage, HttpStatus.NOT_FOUND);
    }
}
