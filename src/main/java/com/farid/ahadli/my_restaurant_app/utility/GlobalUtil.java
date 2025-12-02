package com.farid.ahadli.my_restaurant_app.utility;

import com.farid.ahadli.my_restaurant_app.exception.*;
import com.farid.ahadli.my_restaurant_app.model.Cart;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

 final public  class GlobalUtil {
    static public  void ifMenuItemPresent(Optional<RestaurantMenuItem> item) {
        if (!item.isPresent()) {
            throw AbsentMenuItemException.builder()
                    .statusCode(HttpStatus.NOT_FOUND)
                    .message("No menu item found")
                    .build();
        }
    }

//    public static void ifProperMenuItemId(Long id) {
//        if(Objects.isNull(id)){
//            throw InvalidMenuItemId.builder()
//                    .message("Input Id format is invalid")
//                    .statusCode(HttpStatus.BAD_REQUEST)
//                    .build();
//        }
//    }

    public static void ifMenuEmpty(List<RestaurantMenuItem> MenuItems) {
        if(MenuItems.isEmpty()) {
            throw EmptyMenuException
                    .builder()
                    .message("Menu is empty").
                    statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();

        }
    }


     public static void ifCartEmpty(Map<CustomerRestaurantMenuItemResponseDTO, Integer> cart) {
        if(cart.isEmpty()) {
            throw EmptyCartException.builder()
                    .message("Cart is empty")
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
     }

     public static void ifKeyExist(CustomerRestaurantMenuItemResponseDTO key, Cart cart) {

        if(!cart.getOrders().containsKey(key)) {
            throw ItemNotInCartException.builder()
                    .statusCode(HttpStatus.NOT_FOUND)
                    .message("Menu item is not in the Cart")
                    .build();
        }

     }

     private GlobalUtil() {

     }


 }
