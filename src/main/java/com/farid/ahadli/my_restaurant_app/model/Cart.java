package com.farid.ahadli.my_restaurant_app.model;


import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.*;

@Component
@SessionScope
@Data
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class Cart  {
    @NonFinal
    Double totalPrice = 0d;
    public Map<Long, CartItem> orders = new HashMap<>();
    public void addItem(CartItem item) {
        CartItem prevItem  =  orders.put(item.getCustomerRestaurantMenuItemResponseDTO().getId(), item);
        Double previousItemTotalPrice = Objects.isNull(prevItem)?0d: prevItem.getCartItemTotalPrice();
        totalPrice+=(item.getCartItemTotalPrice()-previousItemTotalPrice);
    }

    public void removeItem(Long id) {
        CartItem item = orders.remove(id);
        totalPrice-=item.getCartItemTotalPrice();
    }

    public void clearCart(){
        orders.clear();
        totalPrice = 0d;
    }
}
