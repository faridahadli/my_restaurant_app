package com.farid.ahadli.my_restaurant_app.model.dto.response;

import com.farid.ahadli.my_restaurant_app.model.TaxType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.Set;
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerRestaurantMenuItemResponseDTO implements Serializable {
    @EqualsAndHashCode.Include
    Long id;

    String name;
    Double price;
    Set<CustomerRestaurantIngredientsResponseDTO> ingredients;
    TaxType taxType;
    Double taxRate;
    Double taxAmount;



}
