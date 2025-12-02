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




}
