package com.farid.ahadli.my_restaurant_app.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import org.springframework.http.HttpStatusCode;


public class InvalidMenuItemId extends BaseRestaurantException {

    @Builder
    public InvalidMenuItemId(String message, HttpStatusCode statusCode) {
        super(message,statusCode);
    }

}
