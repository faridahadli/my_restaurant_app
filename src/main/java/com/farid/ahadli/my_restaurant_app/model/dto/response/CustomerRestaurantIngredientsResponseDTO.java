package com.farid.ahadli.my_restaurant_app.model.dto.response;


import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantIngredients;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerRestaurantIngredientsResponseDTO implements Serializable {
    Long id;

    String name;

    Boolean Allergen;


    public static Set<CustomerRestaurantIngredientsResponseDTO> convertRestaurantIngredientSetToCustomerRestaurantIngredientResponseDTOSet(Set<RestaurantIngredients> ingredients) {
        return ingredients.stream()
                .map(ingredientItem-> CustomerRestaurantIngredientsResponseDTO.builder()
                        .id(ingredientItem.getId())
                        .name(ingredientItem.getName())
                        .Allergen(ingredientItem.getAllergen())
                        .build()

                ).collect(Collectors.toSet());
    }


}
