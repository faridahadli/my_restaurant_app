package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;


public class EmptyMenuException extends BaseRestaurantException {

    @Builder
    public EmptyMenuException(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }

}
