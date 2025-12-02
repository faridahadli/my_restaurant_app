package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

public class ItemNotInCartException extends BaseRestaurantException {

    @Builder
    ItemNotInCartException(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }

}
