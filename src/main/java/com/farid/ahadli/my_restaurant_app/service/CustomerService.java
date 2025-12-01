package com.farid.ahadli.my_restaurant_app.service;

import com.farid.ahadli.my_restaurant_app.GlobalUtil;
import com.farid.ahadli.my_restaurant_app.exception.AbsentMenuItemException;
import com.farid.ahadli.my_restaurant_app.exception.EmptyMenuException;
import com.farid.ahadli.my_restaurant_app.exception.InvalidMenuItemId;
import com.farid.ahadli.my_restaurant_app.model.Cart;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantIngredientsResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantIngredients;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantMenuItemRepository;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
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
       GlobalUtil.isMenuEmpty(MenuItems);
       return CustomerRestaurantMenuItemResponseDTO
               .convertRestaurantMenuItemListToCustomerRestaurantMenuItemResponseDTOList(MenuItems);
    }

    public CustomerRestaurantMenuItemResponseDTO getMenuItemById(Integer id) {
        GlobalUtil.isProperId(id);
        Optional<RestaurantMenuItem> item = restaurantMenuItemRepository.findById(id);
        GlobalUtil.isMenuItemPresent(item);
        return CustomerRestaurantMenuItemResponseDTO
                .convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO(item.get());
    }



}
