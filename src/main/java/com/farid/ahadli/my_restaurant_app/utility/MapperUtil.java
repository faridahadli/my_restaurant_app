package com.farid.ahadli.my_restaurant_app.utility;

import com.farid.ahadli.my_restaurant_app.model.Cart;
import com.farid.ahadli.my_restaurant_app.model.CartItem;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerCartItemResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerCartResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantIngredientsResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantIngredients;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;

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



    private MapperUtil() {

    }

}
