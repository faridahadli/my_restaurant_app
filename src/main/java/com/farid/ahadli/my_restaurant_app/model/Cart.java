package com.farid.ahadli.my_restaurant_app.model;


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


    public Map<RestaurantMenuItem, Integer> orders = new HashMap<>();
    public void addItem(RestaurantMenuItem item, Integer quantity) {
        orders.put(item, quantity);
    }

    public void removeItem(RestaurantMenuItem item) {
        orders.remove(item);

    }


}
