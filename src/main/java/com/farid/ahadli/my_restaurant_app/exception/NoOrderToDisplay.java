package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

public class NoOrderToDisplay extends BaseRestaurantException {
    @Builder
    public NoOrderToDisplay(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }
}
