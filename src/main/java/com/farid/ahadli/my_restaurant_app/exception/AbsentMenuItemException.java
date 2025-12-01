package com.farid.ahadli.my_restaurant_app.exception;

import lombok.Builder;
import org.springframework.http.HttpStatusCode;

public class AbsentMenuItemException  extends BaseRestaurantException{

    @Builder
    public AbsentMenuItemException(String message, HttpStatusCode statusCode) {
        super(message, statusCode);
    }

}
