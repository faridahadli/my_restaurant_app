package com.farid.ahadli.my_restaurant_app.model;


import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
@SessionScope
@Data
@FieldDefaults(level = AccessLevel.PUBLIC,makeFinal = true)

public class Cart implements Serializable {
    @NonFinal
    Double totalPrice = 0d;
    public Map<CustomerRestaurantMenuItemResponseDTO, Integer> orders = new HashMap<>();
    public void addItem(CustomerRestaurantMenuItemResponseDTO item,  Integer quantity) {
        orders.put(item, quantity);
        totalPrice+=item.getPrice()*quantity;
    }

    public void removeItem(CustomerRestaurantMenuItemResponseDTO item) {
        orders.remove(item);
        totalPrice-=item.getPrice();
    }

    public void clearCart(){
        orders.clear();
        totalPrice = 0d;
    }
}
