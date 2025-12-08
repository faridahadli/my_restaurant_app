package com.farid.ahadli.my_restaurant_app.repository;

import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RestaurantMenuItemRepository extends JpaRepository<RestaurantMenuItem, Long> {

    @Query("select MenuItem.id from RestaurantMenuItem MenuItem")
    Set<Long>  getAllIds();

    @Query("select MenuItem from RestaurantMenuItem MenuItem join fetch MenuItem.ingredientSet" )
    List<RestaurantMenuItem> findAllEager();

    @Query("select MenuItem from RestaurantMenuItem MenuItem join fetch MenuItem.ingredientSet where MenuItem.id=:id")
    Optional<RestaurantMenuItem> findByIdEager(Long id);



}
