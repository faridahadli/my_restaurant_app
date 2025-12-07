package com.farid.ahadli.my_restaurant_app.repository;

import com.farid.ahadli.my_restaurant_app.model.OrderStatus;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RestaurantOrdersRepository extends JpaRepository<RestaurantOrders, Long> {

    @Query("select order from RestaurantOrders order " +
            "join fetch order.OrderMenuItemList menuList " +
            "join fetch menuList.menuItem menuitem " +
            "join fetch menuitem.ingredientSet "+
            "where order.orderStatus <> 'READY' " +
            "order by order.orderTime desc ")
    List<RestaurantOrders> getNotReadyAndOrderByOrderTime();

    @Query("select o from RestaurantOrders o where o.id=:id and o.orderStatus in ('PREPARING','RECEIVED')")
    Optional<RestaurantOrders> findByIdAndNotReady(@Param("id") Long id);

}
