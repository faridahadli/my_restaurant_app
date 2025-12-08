package com.farid.ahadli.my_restaurant_app.repository;

import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RestaurantIngredientsRepository extends JpaRepository<RestaurantIngredients, Long> {

//    Set<RestaurantIngredients> findAllById( List<Long> restaurantId);
}