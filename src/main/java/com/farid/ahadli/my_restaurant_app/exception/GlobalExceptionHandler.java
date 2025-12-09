package com.farid.ahadli.my_restaurant_app.exception;

import com.farid.ahadli.my_restaurant_app.utility.GlobalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> handleBaseRestaurantException(RuntimeException ex, HandlerMethod handler){

    String userDetails [] = GlobalUtil.getUsernameAndAuthorities();

        log.error("{} with the authorities : {} encountered an unexpected exception of {} with the message {} when executing {} controller method" +
                " see the stack trace {}", userDetails[0],userDetails[1],
                ex.getClass().getSimpleName(),ex.getMessage(),
                handler.getMethod().getName() ,ex.getStackTrace());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("unexpected error happened");


    }

    @ExceptionHandler(value = BaseRestaurantException.class)
    public ResponseEntity<String> handleBaseRestaurantException(BaseRestaurantException ex, HandlerMethod handler){
        String userDetails [] = GlobalUtil.getUsernameAndAuthorities();
        log.error("{} with the authorities : {} encountered exception of {} with the message {} when executing {} controller method"
                ,userDetails[0],userDetails[1],
                ex.getClass().getSimpleName(),ex.getMessage(),
                handler.getMethod().getName());

        return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
    }

}
