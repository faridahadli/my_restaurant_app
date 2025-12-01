package com.farid.ahadli.my_restaurant_app.repository;

import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantOrdersRepository extends JpaRepository<RestaurantOrders, Integer> {

}
