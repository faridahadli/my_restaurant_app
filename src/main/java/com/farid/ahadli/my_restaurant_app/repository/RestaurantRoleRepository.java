package com.farid.ahadli.my_restaurant_app.repository;

import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RestaurantRoleRepository extends JpaRepository<RestaurantRoles, Long> {

    RestaurantRoles findByRole(String restaurantRole);

    @Query("select r.role from RestaurantRoles r")
    Set<String> findAllReturnRole();

}
