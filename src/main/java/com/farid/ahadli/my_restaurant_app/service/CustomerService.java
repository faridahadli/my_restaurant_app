package com.farid.ahadli.my_restaurant_app.service;

import com.farid.ahadli.my_restaurant_app.exception.AbsentMenuItemException;
import com.farid.ahadli.my_restaurant_app.exception.BaseRestaurantException;
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
       isMenuEmpty(MenuItems);
       return convertRestaurantMenuItemListToCustomerRestaurantMenuItemResponseDTOList(MenuItems);
    }

    public CustomerRestaurantMenuItemResponseDTO getMenuItemById(Integer id) {
        isProperId(id);

        Optional<RestaurantMenuItem> item = restaurantMenuItemRepository.findById(id);

        isMenuItemPresent(item);

        return convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO(item.get());
    }

    private void isMenuItemPresent(Optional<RestaurantMenuItem> item) {
        if (!item.isPresent()) {
            throw AbsentMenuItemException.builder()
                    .statusCode(HttpStatus.NOT_FOUND)
                    .message("No menu item found")
                    .build();
        }
    }

    private void isProperId(Integer id) {
        if(Objects.isNull(id)){
            throw InvalidMenuItemId.builder()
                    .message("Input Id format is invalid")
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    private void isMenuEmpty(List<RestaurantMenuItem> MenuItems) {
        if(MenuItems.isEmpty()) {
            throw EmptyMenuException
                    .builder()
                    .message("Menu is empty").
                    statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();

        }
    }


    private CustomerRestaurantMenuItemResponseDTO convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO (RestaurantMenuItem menuItem) {

        return CustomerRestaurantMenuItemResponseDTO.builder()
                .id(menuItem.getId())
                .name(menuItem.getName())
                .price(menuItem.getPrice())
                .ingredients(
                        convertRestaurantIngredientListToCustomerRestaurantIngredientResponseDTOList(menuItem.getIngredientSet())
                )
                .taxRate(menuItem.getTaxRate())
                .taxType(menuItem.getTaxType())
                .taxAmount(menuItem.getTaxAmount())
                .build();

    }



    private List<CustomerRestaurantMenuItemResponseDTO> convertRestaurantMenuItemListToCustomerRestaurantMenuItemResponseDTOList(List<RestaurantMenuItem> MenuItems) {
       return MenuItems
                .stream()
                .map(this::convertRestaurantMenuItemToCustomerRestaurantMenuItemResponseDTO)
               .collect(Collectors.toList());
    }

    private Set<CustomerRestaurantIngredientsResponseDTO> convertRestaurantIngredientListToCustomerRestaurantIngredientResponseDTOList(Set<RestaurantIngredients> ingredients) {
        return ingredients.stream()
                .map(ingredientItem-> CustomerRestaurantIngredientsResponseDTO.builder()
                        .id(ingredientItem.getId())
                        .name(ingredientItem.getName())
                        .Allergen(ingredientItem.getAllergen())
                        .build()

                ).collect(Collectors.toSet());
    }
}
