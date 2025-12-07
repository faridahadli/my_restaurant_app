package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

public class RoleAlreadyExists extends BaseRestaurantException {
    @Builder
    public RoleAlreadyExists(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }
}
