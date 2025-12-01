package com.farid.ahadli.my_restaurant_app.repository;

import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrderMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantOrderMenuItemRepository extends JpaRepository<RestaurantOrderMenuItem, Integer> {


}
