package com.stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> Exception(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Message: " + e.getMessage());

    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<String> DataNotFoundException(DataNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error Message: " + e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> ServiceException(ServiceException e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Error Message: " + e.getMessage());
    }

}
