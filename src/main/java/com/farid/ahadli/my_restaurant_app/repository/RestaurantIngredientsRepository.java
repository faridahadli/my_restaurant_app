package com.farid.ahadli.my_restaurant_app.repository;

import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantIngredientsRepository extends JpaRepository<RestaurantIngredients, Integer> {

}