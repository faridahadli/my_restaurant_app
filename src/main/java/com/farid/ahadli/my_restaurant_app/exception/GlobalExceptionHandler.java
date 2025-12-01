package com.farid.ahadli.my_restaurant_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = RuntimeException.class)
    public ResponseEntity<String> handleBaseRestaurantException(RuntimeException ex){
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ex.getCause() + "\n" +
                ex.getMessage() +"\n" +
                ex.getStackTrace() +
                ex.getClass().getName());
    }

    @ExceptionHandler(exception = BaseRestaurantException.class)
    public ResponseEntity<String> handleBaseRestaurantException(BaseRestaurantException ex){
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage()+" "+ ex.getClass().getName());
    }

}
