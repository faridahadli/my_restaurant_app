package com.farid.ahadli.my_restaurant_app.service;

import com.farid.ahadli.my_restaurant_app.model.CartItem;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerCartItemResponseDTO;
import com.farid.ahadli.my_restaurant_app.utility.GlobalUtil;
import com.farid.ahadli.my_restaurant_app.model.Cart;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerCartResponseDTO;
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

    public Map<Long, CustomerCartItemResponseDTO> getAllCartItems(){
        return MapperUtil.convertCartItemMapToCustomerCartItemResponseDTO(cart.getOrders()) ;
    }

    public CustomerCartResponseDTO getCart() {

        return MapperUtil.convertCartToCartDTO(cart);

    }

    public CustomerCartItemResponseDTO  getCartItemById(Long id){
        GlobalUtil.ifMenuItemPresent(restaurantMenuItemRepository.findById(id));
        GlobalUtil.ifCartItemExist(id, cart);
        return MapperUtil.convertCartItemToCustomerCartItemResponseDTO(cart.getOrders().get(id));
    }


    public CustomerCartItemResponseDTO addCartItem(Long id, Integer quantity) {
        Optional<RestaurantMenuItem> menuItem = restaurantMenuItemRepository.findById(id);
        GlobalUtil.ifMenuItemPresent(restaurantMenuItemRepository.findById(id));
        CartItem cartItem =  CartItem.builder()
                .customerRestaurantMenuItemResponseDTO(
                        MapperUtil.convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO(menuItem.get())
                )
                .quantity(quantity)
                .build();
        cart.addItem(
                cartItem
        );

        return MapperUtil.convertCartItemToCustomerCartItemResponseDTO(cartItem);
    }

    public void deleteCartItem(Long id) {
        GlobalUtil.ifMenuItemPresent(restaurantMenuItemRepository.findById(id));
        GlobalUtil.ifCartItemExist(id, cart);
        cart.removeItem(id);
    }

   public void deleteAllCartItems(){
        cart.clearCart();
   }

//    public Map<CustomerRestaurantMenuItemResponseDTO, Integer>




}
