package com.landlordassistant.application.exceptionHandling;

import com.landlordassistant.application.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseDto<Void>> handleNoSuchEntityException(NoSuchEntityException exception) {
        String message = exception.getMessage();
        return new ResponseEntity<>(ResponseDto.error(message), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseDto<Void>> handleException(Exception exception) {
        String message = exception.getMessage();
        return new ResponseEntity<>(ResponseDto.error(message), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
