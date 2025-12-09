package com.farid.ahadli.my_restaurant_app.service;


import com.farid.ahadli.my_restaurant_app.model.dto.request.KitchenUpdateOrderRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.KitchenRestaurantOrdersResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantOrders;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantOrdersRepository;
import com.farid.ahadli.my_restaurant_app.utility.GlobalUtil;
import com.farid.ahadli.my_restaurant_app.utility.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Slf4j
public class KitchenService {

    RestaurantOrdersRepository restaurantOrdersRepository;

    public  List<KitchenRestaurantOrdersResponseDTO> getRestaurantOrders(){
        List<RestaurantOrders> restaurantOrders = restaurantOrdersRepository.getNotReadyAndOrderByOrderTime();
        GlobalUtil.IfOrdersExist(restaurantOrders);
        return restaurantOrders.stream().map(MapperUtil::convertRestaurantOrdersToKitchenRestaurantOrdersResponseDTO).toList();

    }
    public KitchenRestaurantOrdersResponseDTO getRestaurantOrderById(String id){
        Optional<RestaurantOrders> restaurantOrders = restaurantOrdersRepository.findByIdAndNotReady(id);
        GlobalUtil.ifOrderExists(restaurantOrders);
        return MapperUtil.convertRestaurantOrdersToKitchenRestaurantOrdersResponseDTO(restaurantOrders.get()) ;
    }
    @Transactional
    public void updateOrderStatus(String id, KitchenUpdateOrderRequestDTO kitchenUpdateOrderRequestDTO){
        Optional<RestaurantOrders> restaurantOrders = restaurantOrdersRepository.findByIdAndNotReady(id);
        GlobalUtil.ifOrderExists(restaurantOrders);
        RestaurantOrders restaurantOrder = restaurantOrders.get();
        restaurantOrder.setOrderStatus(kitchenUpdateOrderRequestDTO.getKitchenStatus());
        restaurantOrdersRepository.save(restaurantOrder);

        String[] userDetails = GlobalUtil.getUsernameAndAuthorities();
        log.info("{} with the authorities : {} changed the order status of {} to {}" , userDetails[0], userDetails[1],id, restaurantOrder.getOrderStatus());


    }

}
