package com.farid.ahadli.my_restaurant_app.entity;


import com.farid.ahadli.my_restaurant_app.model.TakeAway;
import jakarta.persistence.*;
import lombok.NonNull;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "orders")
public class RestaurantOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long orderId;

    Long restaurantId;

    @Temporal(TemporalType.TIMESTAMP)
    Date orderDate;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TakeAway takeAway;

//    @OneToMany
//    @JoinColumn(name = "menu_id", nullable = false)
    //Map<, > restaurantIngredients = new HashMap<>();



}
