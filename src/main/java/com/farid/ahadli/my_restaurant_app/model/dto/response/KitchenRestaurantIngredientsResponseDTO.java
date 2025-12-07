package com.farid.ahadli.my_restaurant_app.model.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KitchenRestaurantIngredientsResponseDTO {
    Long id;
    String name;
    Boolean Allergen;
}
