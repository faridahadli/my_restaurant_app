package com.farid.ahadli.my_restaurant_app.utility;

import com.farid.ahadli.my_restaurant_app.model.Cart;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CartDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantIngredientsResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantIngredients;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

final public class MapperUtil {

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

    public static List<CustomerRestaurantMenuItemResponseDTO> convertRestaurantMenuItemListToCustomerRestaurantMenuItemResponseDTOList(List<RestaurantMenuItem> MenuItems) {
        return MenuItems
                .stream()
                .map(MapperUtil::convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO)
                .collect(Collectors.toList());
    }

    public static Set<CustomerRestaurantIngredientsResponseDTO> convertRestaurantIngredientSetToCustomerRestaurantIngredientResponseDTOSet(Set<RestaurantIngredients> ingredients) {
        return ingredients.stream()
                .map(ingredientItem-> CustomerRestaurantIngredientsResponseDTO.builder()
                        .id(ingredientItem.getId())
                        .name(ingredientItem.getName())
                        .Allergen(ingredientItem.getAllergen())
                        .build()

                ).collect(Collectors.toSet());
    }

    public static CartDTO CartToCartDTO( Cart cart) {
        return CartDTO.builder()
                .orders(cart.getOrders())
                .totalPrice(cart.getTotalPrice())
                .build();
    }

    private MapperUtil() {

    }

}
