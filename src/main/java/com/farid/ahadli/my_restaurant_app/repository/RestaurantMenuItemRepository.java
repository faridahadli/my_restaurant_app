package com.farid.ahadli.my_restaurant_app.repository;

import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantMenuItemRepository extends JpaRepository<RestaurantMenuItem, Integer> {

}
