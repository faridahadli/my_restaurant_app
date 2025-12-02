package com.farid.ahadli.my_restaurant_app.service;

import com.farid.ahadli.my_restaurant_app.utility.GlobalUtil;
import com.farid.ahadli.my_restaurant_app.model.Cart;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CartDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantMenuItemRepository;
import com.farid.ahadli.my_restaurant_app.utility.MapperUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Data
@Slf4j
public class CustomerService {

    Cart cart;
    RestaurantMenuItemRepository restaurantMenuItemRepository;
    public List<CustomerRestaurantMenuItemResponseDTO> getMenuItems() {
       List<RestaurantMenuItem> MenuItems = restaurantMenuItemRepository.findAll();
       GlobalUtil.ifMenuEmpty(MenuItems);
       return MapperUtil
               .convertRestaurantMenuItemListToCustomerRestaurantMenuItemResponseDTOList(MenuItems);
    }

    public CustomerRestaurantMenuItemResponseDTO getMenuItemById(Long id) {
       // GlobalUtil.ifProperMenuItemId(id);
        Optional<RestaurantMenuItem> item = restaurantMenuItemRepository.findById(id);
        GlobalUtil.ifMenuItemPresent(item);
        return MapperUtil
                .convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO(item.get());
    }

    public Map<CustomerRestaurantMenuItemResponseDTO, Integer> getAllCartItems(){
        return cart.getOrders();
    }

    public CartDTO getCart() {
        return MapperUtil.CartToCartDTO(cart);
    }

    public Map<CustomerRestaurantMenuItemResponseDTO, Integer>  getCartItemById(Long id){

        CustomerRestaurantMenuItemResponseDTO key =  CustomerRestaurantMenuItemResponseDTO.builder().build();
        key.setId(id);

        GlobalUtil.ifKeyExist(key, cart);



        return cart.getOrders().entrySet()
                .stream()
                .filter(
                        i-> i.getKey().equals(key)
                )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

//    public Map<CustomerRestaurantMenuItemResponseDTO, Integer>




}
