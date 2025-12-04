package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

public class OrderGettingPreparedException extends BaseRestaurantException {
    @Builder
    OrderGettingPreparedException(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }
}
