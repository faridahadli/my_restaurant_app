package com.farid.ahadli.my_restaurant_app.model.dto.response;

import com.farid.ahadli.my_restaurant_app.model.TaxType;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerRestaurantMenuItemResponseDTO implements Serializable {
    Long id;
    String name;
    Double price;
    Set<CustomerRestaurantIngredientsResponseDTO> ingredients;
    TaxType taxType;
    Double taxRate;
    Double taxAmount;

    public static CustomerRestaurantMenuItemResponseDTO convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO (RestaurantMenuItem menuItem) {

        return CustomerRestaurantMenuItemResponseDTO.builder()
                .id(menuItem.getId())
                .name(menuItem.getName())
                .price(menuItem.getPrice())
                .ingredients(
                        CustomerRestaurantIngredientsResponseDTO.convertRestaurantIngredientSetToCustomerRestaurantIngredientResponseDTOSet(menuItem.getIngredientSet())
                )
                .taxRate(menuItem.getTaxRate())
                .taxType(menuItem.getTaxType())
                .taxAmount(menuItem.getTaxAmount())
                .build();

    }



    public static List<CustomerRestaurantMenuItemResponseDTO> convertRestaurantMenuItemListToCustomerRestaurantMenuItemResponseDTOList(List<RestaurantMenuItem> MenuItems) {
        return MenuItems
                .stream()
                .map(CustomerRestaurantMenuItemResponseDTO::convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO)
                .collect(Collectors.toList());
    }


}
