package com.farid.ahadli.my_restaurant_app;

import com.farid.ahadli.my_restaurant_app.exception.AbsentMenuItemException;
import com.farid.ahadli.my_restaurant_app.exception.EmptyMenuException;
import com.farid.ahadli.my_restaurant_app.exception.InvalidMenuItemId;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GlobalUtil {
    public static void isMenuItemPresent(Optional<RestaurantMenuItem> item) {
        if (!item.isPresent()) {
            throw AbsentMenuItemException.builder()
                    .statusCode(HttpStatus.NOT_FOUND)
                    .message("No menu item found")
                    .build();
        }
    }

    public static void isProperId(Integer id) {
        if(Objects.isNull(id)){
            throw InvalidMenuItemId.builder()
                    .message("Input Id format is invalid")
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    public static void isMenuEmpty(List<RestaurantMenuItem> MenuItems) {
        if(MenuItems.isEmpty()) {
            throw EmptyMenuException
                    .builder()
                    .message("Menu is empty").
                    statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();

        }
    }
}
