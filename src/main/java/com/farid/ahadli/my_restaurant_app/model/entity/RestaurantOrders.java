package com.farid.ahadli.my_restaurant_app.model.entity;


import com.farid.ahadli.my_restaurant_app.model.DiningOption;
import com.farid.ahadli.my_restaurant_app.model.PaymentMethod;
import com.farid.ahadli.my_restaurant_app.model.TableEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column(nullable = false, name = "restaurant_id")
    Long restaurantId;


    @Column(nullable = false, name = "order_date")
    Instant orderTime;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "dining_option")
    DiningOption diningOption;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TableEnum table ;




    @OneToMany(
                mappedBy = "order",
                cascade = {
                        CascadeType.PERSIST,
                        CascadeType.REMOVE
                }
    )
    List<RestaurantOrderMenuItem> OrderMenuItemList = new ArrayList<>();

    public  void addMenuItem(RestaurantOrderMenuItem menuItem) {
        if(Objects.nonNull(menuItem)){
            OrderMenuItemList.add(menuItem) ;
        }
    }



}
