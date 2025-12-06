package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;


public class UserAlreadyExistsException extends BaseRestaurantException {

    @Builder
    public UserAlreadyExistsException(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }
}
