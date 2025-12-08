package com.farid.ahadli.my_restaurant_app.utility;

import com.farid.ahadli.my_restaurant_app.model.Cart;
import com.farid.ahadli.my_restaurant_app.model.CartItem;
import com.farid.ahadli.my_restaurant_app.model.dto.response.*;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantIngredients;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrderMenuItem;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

final public class MapperUtil {

    //region CustomerRestaurantMenuItemResponseDTO
    public static CustomerRestaurantMenuItemResponseDTO convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO (RestaurantMenuItem menuItem) {

        return CustomerRestaurantMenuItemResponseDTO.builder()
                .id(menuItem.getId())
                .name(menuItem.getName())
                .price(menuItem.getPrice())
                .ingredients(
                        convertRestaurantIngredientSetToCustomerRestaurantIngredientResponseDTOSet(menuItem.getIngredientSet())
                )
                .taxRate(menuItem.getTaxRate())
                .taxType(menuItem.getTaxType())
                .taxAmount(menuItem.getTaxAmount())
                .build();

    }

//    public static RestaurantMenuItem  convertCustomerRestaurantMenuItemResponseDTOtoRestaurantMenuItem( CustomerRestaurantMenuItemResponseDTO customerRestaurantMenuItemResponseDTO) {
//        RestaurantMenuItem.builder()
//                .id(customerRestaurantMenuItemResponseDTO.getId())
//                .name(customerRestaurantMenuItemResponseDTO.getName())
//                .price(customerRestaurantMenuItemResponseDTO.getPrice())
//                .taxRate(customerRestaurantMenuItemResponseDTO.getTaxRate())
//                .taxType(customerRestaurantMenuItemResponseDTO.getTaxType())
//                .taxAmount(customerRestaurantMenuItemResponseDTO.getTaxAmount())
//                .ingredientSet(customerRestaurantMenuItemResponseDTO.getIngredients())
//                .build();
//
//    }

    public static List<CustomerRestaurantMenuItemResponseDTO> convertRestaurantMenuItemListToCustomerRestaurantMenuItemResponseDTOList(List<RestaurantMenuItem> MenuItems) {
        return MenuItems
                .stream()
                .map(MapperUtil::convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO)
                .collect(Collectors.toList());
    }
// endregion
    // region CustomerRestaurantIngredientsResponseDTO
    public static Set<CustomerRestaurantIngredientsResponseDTO> convertRestaurantIngredientSetToCustomerRestaurantIngredientResponseDTOSet(Set<RestaurantIngredients> ingredients) {
        return ingredients.stream()
                .map(ingredientItem-> CustomerRestaurantIngredientsResponseDTO.builder()
                        .id(ingredientItem.getId())
                        .name(ingredientItem.getName())
                        .Allergen(ingredientItem.getAllergen())
                        .build()

                ).collect(Collectors.toSet());
    }
    // endregion



    public static CustomerCartResponseDTO convertCartToCartDTO(Cart cart) {
        return CustomerCartResponseDTO.builder()
                .orders(
                        convertCartItemMapToCustomerCartItemResponseDTO(cart.getOrders())
                )
                .totalPrice(cart.getTotalPrice())
                .build();
    }



    public static Map<Long, CustomerCartItemResponseDTO>  convertCartItemMapToCustomerCartItemResponseDTO( Map<Long, CartItem>  cartItemMap) {
         Map<Long, CustomerCartItemResponseDTO> out = new HashMap<>();
         for(Long id: cartItemMap.keySet()) {
             out.put(id, convertCartItemToCustomerCartItemResponseDTO(cartItemMap.get(id)));
         }
         return out;
    }

    public static CustomerCartItemResponseDTO convertCartItemToCustomerCartItemResponseDTO(CartItem cartItem){
        return CustomerCartItemResponseDTO.builder()
                .cartItemTotalPrice(cartItem.getCartItemTotalPrice())
                .customerRestaurantMenuItemResponseDTO(cartItem.getCustomerRestaurantMenuItemResponseDTO())
                .quantity(cartItem.getQuantity())
                .build();
    }



  public static  CustomerRestaurantOrderMenuItemResponseDTO convertRestaurantOrderMenuItemToCustomerRestaurantOrderMenuItemResponseDTO (RestaurantOrderMenuItem restaurantOrderMenuItem) {

       return CustomerRestaurantOrderMenuItemResponseDTO.builder()
                .itemTaxTotal(restaurantOrderMenuItem.getItemTaxTotal())
                .itemTotal(restaurantOrderMenuItem.getItemTotal())
                .customerRestaurantMenuItemResponseDTO(convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO(restaurantOrderMenuItem.getMenuItem()))
                .build();
    }

    public static  CustomerRestaurantOrdersResponseDTO convertRestaurantOrdersToCustomerRestaurantOrdersResponseDTO (RestaurantOrders restaurantOrdersResponseDTO) {
       return  CustomerRestaurantOrdersResponseDTO.builder()
               .diningOption( restaurantOrdersResponseDTO.getDiningOption() )
               .table(restaurantOrdersResponseDTO.getTable())
               .orderStatus(restaurantOrdersResponseDTO.getOrderStatus())
               .restaurantOrderMenuItemResponseDTOList(restaurantOrdersResponseDTO.getOrderMenuItemList()
                       .stream()
                       .map(MapperUtil::convertRestaurantOrderMenuItemToCustomerRestaurantOrderMenuItemResponseDTO)
                       .toList()
               )
               .build();
    }

    public static KitchenRestaurantOrdersResponseDTO convertRestaurantOrdersToKitchenRestaurantOrdersResponseDTO(RestaurantOrders restaurantOrders) {

       return KitchenRestaurantOrdersResponseDTO.builder()
                .diningOption( restaurantOrders.getDiningOption() )
                .table(restaurantOrders.getTable())
                .orderStatus(restaurantOrders.getOrderStatus())
                .restaurantOrderMenuItemResponseDTOList(restaurantOrders.getOrderMenuItemList()
                        .stream()
                        .map(MapperUtil::convertRestaurantOrderMenuItemToKitchenOrderMenuItemResponseDTO)
                        .toList()
                )
                .build();
    }


    public static KitchenRestaurantOrderMenuItemResponseDTO  convertRestaurantOrderMenuItemToKitchenOrderMenuItemResponseDTO( RestaurantOrderMenuItem restaurantOrderMenuItem ){
       return   KitchenRestaurantOrderMenuItemResponseDTO.builder()
                .itemTaxTotal(restaurantOrderMenuItem.getItemTaxTotal())
                .itemTotal(restaurantOrderMenuItem.getItemTotal())
                .kitchenRestaurantMenuItemResponseDTO(convertRestaurantMenuItemToKitchenRestaurantMenuItemResponseDTO(restaurantOrderMenuItem.getMenuItem()))
                .build();
    }

    public static KitchenRestaurantMenuItemResponseDTO convertRestaurantMenuItemToKitchenRestaurantMenuItemResponseDTO(RestaurantMenuItem restaurantMenuItem) {
        return KitchenRestaurantMenuItemResponseDTO.builder()
                .id(restaurantMenuItem.getId())
                .name(restaurantMenuItem.getName())
                .price(restaurantMenuItem.getPrice())
                .taxType(restaurantMenuItem.getTaxType())
                .taxAmount(restaurantMenuItem.getTaxAmount())
                .taxRate(restaurantMenuItem.getTaxRate())
                .ingredients(  convertRestaurantIngredientSetToKitchenRestaurantIngredientResponseDTOSet(restaurantMenuItem.getIngredientSet()))
                .build();
    }

    public static Set<KitchenRestaurantIngredientsResponseDTO> convertRestaurantIngredientSetToKitchenRestaurantIngredientResponseDTOSet(Set<RestaurantIngredients> ingredients) {
        return ingredients.stream()
                .map(ingredientItem-> KitchenRestaurantIngredientsResponseDTO.builder()
                        .id(ingredientItem.getId())
                        .name(ingredientItem.getName())
                        .Allergen(ingredientItem.getAllergen())
                        .build()

                ).collect(Collectors.toSet());
    }



    public static AdminRestaurantMenuItemResponseDTO convertRestaurantMenuItemToAdminRestaurantMenuItemResponseDTO(RestaurantMenuItem restaurantMenuItem) {
        return AdminRestaurantMenuItemResponseDTO.builder()
                .id(restaurantMenuItem.getId())
                .name(restaurantMenuItem.getName())
                .price(restaurantMenuItem.getPrice())
                .taxType(restaurantMenuItem.getTaxType())
                .taxAmount(restaurantMenuItem.getTaxAmount())
                .taxRate(restaurantMenuItem.getTaxRate())
                .ingredients(  convertRestaurantIngredientSetToAdminRestaurantIngredientResponseDTOSet(restaurantMenuItem.getIngredientSet()))
                .build();
    }

    public static Set<AdminRestaurantIngredientsResponseDTO> convertRestaurantIngredientSetToAdminRestaurantIngredientResponseDTOSet(Set<RestaurantIngredients> ingredients) {
        return ingredients.stream()
                .map(ingredientItem-> AdminRestaurantIngredientsResponseDTO.builder()
                        .id(ingredientItem.getId())
                        .name(ingredientItem.getName())
                        .Allergen(ingredientItem.getAllergen())
                        .build()

                ).collect(Collectors.toSet());
    }

    public static AdminRestaurantOrdersResponseDTO convertRestaurantOrdersToAdminRestaurantOrdersResponseDTO(RestaurantOrders restaurantOrders) {

        return AdminRestaurantOrdersResponseDTO.builder()
                .diningOption( restaurantOrders.getDiningOption() )
                .table(restaurantOrders.getTable())
                .orderStatus(restaurantOrders.getOrderStatus())
                .adminRestaurantMenuItemResponseDTOList(restaurantOrders.getOrderMenuItemList()
                        .stream()
                        .map(MapperUtil::convertRestaurantOrderMenuItemToAdminOrderMenuItemResponseDTO)
                        .toList()
                )
                .build();
    }


    public static AdminRestaurantOrderMenuItemResponseDTO  convertRestaurantOrderMenuItemToAdminOrderMenuItemResponseDTO( RestaurantOrderMenuItem restaurantOrderMenuItem ){
        return   AdminRestaurantOrderMenuItemResponseDTO.builder()
                .itemTaxTotal(restaurantOrderMenuItem.getItemTaxTotal())
                .itemTotal(restaurantOrderMenuItem.getItemTotal())
                .adminRestaurantMenuItemResponseDTO(convertRestaurantMenuItemToAdminRestaurantMenuItemResponseDTO(restaurantOrderMenuItem.getMenuItem()))
                .build();
    }
    
    
    private MapperUtil() {

    }


}
