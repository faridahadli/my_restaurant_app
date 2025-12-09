package com.farid.ahadli.my_restaurant_app.model.dto.response;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
@Builder
public class CustomerCartItemResponseDTO {
    Double cartItemTotalPrice;
    CustomerRestaurantMenuItemResponseDTO   customerRestaurantMenuItemResponseDTO;
    Integer quantity;
}
