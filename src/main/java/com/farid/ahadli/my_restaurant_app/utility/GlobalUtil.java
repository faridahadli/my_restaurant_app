package com.farid.ahadli.my_restaurant_app.utility;

import com.farid.ahadli.my_restaurant_app.exception.*;
import com.farid.ahadli.my_restaurant_app.model.Cart;
import com.farid.ahadli.my_restaurant_app.model.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Objects;
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

    public static void ifMenuEmpty(List<RestaurantMenuItem> MenuItems) {
        if(MenuItems.isEmpty()) {
            throw EmptyMenuException
                    .builder()
                    .message("Menu is empty").
                    statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();

        }
    }


     public static void ifCartEmpty(Cart cart) {
        if(cart.isEmpty()) {
            throw EmptyCartException.builder()
                    .message("Cart is empty")
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
     }

     public static void ifCartItemExist(Long id, Cart cart) {

        if(!cart.getOrders().containsKey(id)) {
            throw ItemNotInCartException.builder()
                    .statusCode(HttpStatus.NOT_FOUND)
                    .message("Item is not in the Cart")
                    .build();
        }

     }
     public static void ifOrderExists(Optional<RestaurantOrders> order) {
        if(order.isEmpty()) {
            throw OrderNotFoundException.builder()
                    .message("Order with the given id not present")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

     public static void ifOrderCancellable(RestaurantOrders orderReal) {
         switch (orderReal.getOrderStatus()) {
             case RECEIVED -> {
             }
             case READY -> throw OrderReadyException.builder()
                     .message("Order is ready and cannot be cancelled")
                     .statusCode(HttpStatus.BAD_REQUEST)
                     .build();
             case PREPARING -> throw OrderGettingPreparedException.builder()
                     .message("Order is getting prepared, cannot cancel")
                     .statusCode(HttpStatus.BAD_REQUEST)
                     .build();
         }
     }

     public static void ifUserExist(RestaurantUser user) {
        if( Objects.nonNull(user)){
             throw UserAlreadyExistsException.builder()
                     .statusCode(HttpStatus.BAD_REQUEST)
                     .message("User already exists")
                     .build();
         }
     }

     public static void ifRoleExists(RestaurantRoles userRole) {
            if(Objects.isNull(userRole)){
                throw NoSuchRoleException.builder()
                        .statusCode(HttpStatus.BAD_REQUEST)
                        .message("You cannot add a user with a new role role")
                        .build();
         }
     }
     public static void ifRoleAbsent(RestaurantRoles role) {
        if(Objects.nonNull(role)){
            throw RoleAlreadyExists.builder()
                    .message("You cannot add a role that alrady exists")
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
     }

     public static void IfOrdersExist(List<RestaurantOrders> orders) {
        if(orders.isEmpty()){
            throw NoOrderToDisplay.builder()
                    .message("No orders to display at the moment")
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
     }

     public static void ifCorrectIngredientIds(List<RestaurantIngredients> restaurantIngredients,Integer size) {
        if(restaurantIngredients.size()!=size){
            throw WrongIngredientIds.builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .message("Wrong ingredient ids")
                    .build();
        }
     }

     public static String[] getUsernameAndAuthorities(){
         Authentication user = SecurityContextHolder.getContext().getAuthentication();
         String username = Objects.isNull(user) ? "anonymousUser" : user.getName();
         String role = Objects.isNull(user) ? "ROLE_ANONYMOUS" : user.getAuthorities().toString();
         return new String[]{username,role};
     }

     private GlobalUtil() {

     }


     public static void ifIngredientPresent(Optional<RestaurantIngredients> ingredient) {
         if (!ingredient.isPresent()) {
             throw AbsentIngredientException.builder()
                     .statusCode(HttpStatus.NOT_FOUND)
                     .message("No such menu item found")
                     .build();
         }
     }
 }
