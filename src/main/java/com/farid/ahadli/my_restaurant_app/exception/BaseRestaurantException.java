package com.farid.ahadli.my_restaurant_app.exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatusCode;

@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Data
public class BaseRestaurantException extends RuntimeException {
    String message;
    HttpStatusCode statusCode;

    public BaseRestaurantException(String message, HttpStatusCode statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
