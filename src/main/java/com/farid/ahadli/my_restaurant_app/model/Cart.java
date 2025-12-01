package com.farid.ahadli.my_restaurant_app.model;


import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@Component
@SessionScope
@Data
@FieldDefaults(level = AccessLevel.PUBLIC,makeFinal = true)

public class Cart {


    public Map<CustomerRestaurantMenuItemResponseDTO, Integer> orders = new HashMap<>();
    public void addItem(CustomerRestaurantMenuItemResponseDTO item, Integer quantity) {
        orders.put(item, quantity);
    }

    public void removeItem(CustomerRestaurantMenuItemResponseDTO item) {
        orders.remove(item);

    }



}
