package com.farid.ahadli.my_restaurant_app.model.dto.response;


import com.farid.ahadli.my_restaurant_app.model.TaxType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdminRestaurantMenuItemResponseDTO {

    Long id;
    String name;
    Double price;
    Set<AdminRestaurantIngredientsResponseDTO> ingredients;
    TaxType taxType;
    Double taxRate;
    Double taxAmount;

}
