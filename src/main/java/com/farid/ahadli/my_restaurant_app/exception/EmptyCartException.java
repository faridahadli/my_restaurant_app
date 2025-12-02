package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

public class EmptyCartException extends BaseRestaurantException {

    @Builder
    EmptyCartException(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }
}
