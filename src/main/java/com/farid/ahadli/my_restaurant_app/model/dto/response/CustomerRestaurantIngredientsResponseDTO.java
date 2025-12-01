package com.farid.ahadli.my_restaurant_app.model.dto.response;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerRestaurantIngredientsResponseDTO implements Serializable {
    Long id;

    String name;

    Boolean Allergen;


}
