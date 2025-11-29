package com.farid.ahadli.my_restaurant_app.model;


import com.farid.ahadli.my_restaurant_app.entity.RestaurantMenuItem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@Component
@SessionScope
@Data
@FieldDefaults(level = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    public Map<RestaurantMenuItem, Integer> orders = new HashMap<>();

}
