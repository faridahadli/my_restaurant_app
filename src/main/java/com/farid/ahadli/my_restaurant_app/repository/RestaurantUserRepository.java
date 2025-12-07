package com.farid.ahadli.my_restaurant_app.repository;

import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface RestaurantUserRepository extends JpaRepository<RestaurantUser, Long> {

    RestaurantUser findByUsername(String username);

    @Query("select u.username from RestaurantUser u")
    Set<String> findAllReturnUsernames();

    @Query("delete from  RestaurantUser u where u.username=:username")
    @Modifying
    void deleteByUsername(@Param("username") String username);
}
