package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

public class WrongIngredientIds extends BaseRestaurantException {
    @Builder
    public WrongIngredientIds(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }
}
