package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

public class NoSuchRoleException extends BaseRestaurantException{

    @Builder
    public NoSuchRoleException(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }

}
