package com.farid.ahadli.my_restaurant_app.model.entity;


import com.farid.ahadli.my_restaurant_app.model.DiningOption;
import com.farid.ahadli.my_restaurant_app.model.OrderStatus;
import com.farid.ahadli.my_restaurant_app.model.PaymentMethod;
import com.farid.ahadli.my_restaurant_app.model.TableEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
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
@Builder
public class RestaurantOrders {

    @Id
    String id;


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
    @Column(nullable = false, name = "table_number")
    TableEnum table ;

    @Column(nullable = false)
    Double totalPrice;

    @Column(nullable = false)
    Double totalTax;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

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

    public RestaurantOrders(Long restaurantId, Instant orderTime, DiningOption diningOption, PaymentMethod paymentMethod, TableEnum table, OrderStatus orderStatus) {
        this.restaurantId = restaurantId;
        this.orderTime = orderTime;
        this.diningOption = diningOption;
        this.paymentMethod = paymentMethod;
        this.table = table;
        this.orderStatus = orderStatus;
    }
}
