package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

public class OrderNotFoundException extends BaseRestaurantException{
    @Builder
    OrderNotFoundException(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }
}
