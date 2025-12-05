package com.farid.ahadli.my_restaurant_app.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart  {
    Double totalPrice = 0d;
    Double totalTax = 0d;
    public final Map<Long, CartItem> orders = new HashMap<>();
    public void addOrUpdateItem(CartItem item) {
        CartItem prevItem  =  orders.put(item.getCustomerRestaurantMenuItemResponseDTO().getId(), item);
        Double previousItemTotalPrice = Objects.isNull(prevItem)?0d: prevItem.getCartItemTotalPrice();
        totalPrice+=(item.getCartItemTotalPrice()-previousItemTotalPrice);
        Double previousItemTotalTax = previousItemTotalPrice == 0?0d: prevItem.getCartItemTotalTax();
        totalTax+=(item.getCartItemTotalTax()-previousItemTotalTax);
    }

    public void removeItem(Long id) {
        CartItem item = orders.remove(id);
        totalPrice-=item.getCartItemTotalPrice();
        totalTax-=item.getCartItemTotalTax();
    }

    public void clearCart(){
        orders.clear();
        totalPrice = 0d;
        totalTax = 0d;
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }




}
