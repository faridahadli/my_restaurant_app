package com.farid.ahadli.my_restaurant_app.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Entity
@Table(name = "order_menu_item")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RestaurantOrderMenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    RestaurantOrders order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    RestaurantMenuItem menuItem;

    Integer quantity;

    Double itemTotal;

    Double itemTaxTotal;



    public void setOrder(RestaurantOrders order) {
        if(Objects.nonNull(order)) {
            this.order = order;
            order.addMenuItem(this);
        }
    }
}
