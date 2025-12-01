package com.farid.ahadli.my_restaurant_app.model.dto.response;

import com.farid.ahadli.my_restaurant_app.model.TaxType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

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

}
