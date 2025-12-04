package com.farid.ahadli.my_restaurant_app.model.dto.response;

import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrders;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Data
@Builder

public class CustomerRestaurantOrderMenuItemResponseDTO {

    CustomerRestaurantMenuItemResponseDTO customerRestaurantMenuItemResponseDTO;
    Integer quantity;
    Double itemTotal;
    Double itemTaxTotal;


}
