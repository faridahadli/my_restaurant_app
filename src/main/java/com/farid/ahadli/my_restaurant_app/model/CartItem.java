package com.farid.ahadli.my_restaurant_app.model;

import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Map;


@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem {


    Double cartItemTotalPrice;
    CustomerRestaurantMenuItemResponseDTO   customerRestaurantMenuItemResponseDTO;
    Integer quantity;



    @Builder
    public CartItem(CustomerRestaurantMenuItemResponseDTO customerRestaurantMenuItemResponseDTO, Integer quantity) {

        this.customerRestaurantMenuItemResponseDTO = customerRestaurantMenuItemResponseDTO;
        this.quantity = quantity;
        cartItemTotalPrice = customerRestaurantMenuItemResponseDTO.getPrice()*quantity;

    }

    public Double getCartItemTotalPrice() {
        return cartItemTotalPrice;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        cartItemTotalPrice = customerRestaurantMenuItemResponseDTO.getPrice()*quantity;
    }

    public CustomerRestaurantMenuItemResponseDTO getCustomerRestaurantMenuItemResponseDTO() {
        return customerRestaurantMenuItemResponseDTO;
    }

    public void setCustomerRestaurantMenuItemResponseDTO(CustomerRestaurantMenuItemResponseDTO customerRestaurantMenuItemResponseDTO) {
        this.customerRestaurantMenuItemResponseDTO = customerRestaurantMenuItemResponseDTO;
        cartItemTotalPrice = customerRestaurantMenuItemResponseDTO.getPrice()*quantity;
    }

    @Override
    public boolean equals(Object obj) {
        return customerRestaurantMenuItemResponseDTO.equals(obj);
    }

    @Override
    public int hashCode() {
        return customerRestaurantMenuItemResponseDTO.hashCode();
    }


}
