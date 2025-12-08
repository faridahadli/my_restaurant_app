package com.farid.ahadli.my_restaurant_app.model.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Data
@Builder
public class AdminRestaurantOrderMenuItemResponseDTO {
    AdminRestaurantMenuItemResponseDTO adminRestaurantMenuItemResponseDTO;
    Integer quantity;
    Double itemTotal;
    Double itemTaxTotal;

}
