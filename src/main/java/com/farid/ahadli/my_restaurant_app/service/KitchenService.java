package com.farid.ahadli.my_restaurant_app.service;

import com.farid.ahadli.my_restaurant_app.model.OrderStatus;
import com.farid.ahadli.my_restaurant_app.model.dto.request.KitchenUpdateOrderRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.KitchenRestaurantOrdersResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrders;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantOrdersRepository;
import com.farid.ahadli.my_restaurant_app.utility.GlobalUtil;
import com.farid.ahadli.my_restaurant_app.utility.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KitchenService {

    RestaurantOrdersRepository restaurantOrdersRepository;

    public  List<KitchenRestaurantOrdersResponseDTO> getRestaurantOrders(){
        List<RestaurantOrders> restaurantOrders = restaurantOrdersRepository.getNotReadyAndOrderByOrderTime();
        GlobalUtil.IfOrdersExist(restaurantOrders);
        return restaurantOrders.stream().map(MapperUtil::convertRestaurantOrdersToKitchenRestaurantOrdersResponseDTO).toList();

    }
    public KitchenRestaurantOrdersResponseDTO getRestaurantOrderById(Long id){
        Optional<RestaurantOrders> restaurantOrders = restaurantOrdersRepository.findByIdAndNotReady(id);
        GlobalUtil.ifOrderExists(restaurantOrders);
        return MapperUtil.convertRestaurantOrdersToKitchenRestaurantOrdersResponseDTO(restaurantOrders.get()) ;
    }

    public void updateOrderStatus(Long id, KitchenUpdateOrderRequestDTO kitchenUpdateOrderRequestDTO){
        Optional<RestaurantOrders> restaurantOrders = restaurantOrdersRepository.findByIdAndNotReady(id);
        GlobalUtil.ifOrderExists(restaurantOrders);
        RestaurantOrders restaurantOrder = restaurantOrders.get();
        restaurantOrder.setOrderStatus(OrderStatus.valueOf(kitchenUpdateOrderRequestDTO.getKitchenStatus()));
        restaurantOrdersRepository.save(restaurantOrder);
    }

}
