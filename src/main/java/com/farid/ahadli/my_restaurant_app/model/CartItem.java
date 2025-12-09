package com.farid.ahadli.my_restaurant_app.model;

import com.farid.ahadli.my_restaurant_app.model.dto.response.CustomerRestaurantMenuItemResponseDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem {


    Double cartItemTotalPrice;
    CustomerRestaurantMenuItemResponseDTO   customerRestaurantMenuItemResponseDTO;
    Integer quantity;
    Double cartItemTotalTax;



    @Builder
    public CartItem(CustomerRestaurantMenuItemResponseDTO customerRestaurantMenuItemResponseDTO, Integer quantity) {

        this.customerRestaurantMenuItemResponseDTO = customerRestaurantMenuItemResponseDTO;
        this.quantity = quantity;
        cartItemTotalPrice = customerRestaurantMenuItemResponseDTO.getPrice()*quantity;
        cartItemTotalTax = customerRestaurantMenuItemResponseDTO.getTaxAmount()*quantity;

    }

    public Double getCartItemTotalPrice() {
        return cartItemTotalPrice;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public Double getCartItemTotalTax() {
        return cartItemTotalTax;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        cartItemTotalPrice = customerRestaurantMenuItemResponseDTO.getPrice()*quantity;
        cartItemTotalTax = customerRestaurantMenuItemResponseDTO.getTaxAmount()*quantity;
    }

    public CustomerRestaurantMenuItemResponseDTO getCustomerRestaurantMenuItemResponseDTO() {
        return customerRestaurantMenuItemResponseDTO;
    }

    public void setCustomerRestaurantMenuItemResponseDTO(CustomerRestaurantMenuItemResponseDTO customerRestaurantMenuItemResponseDTO) {
        this.customerRestaurantMenuItemResponseDTO = customerRestaurantMenuItemResponseDTO;
        cartItemTotalPrice = customerRestaurantMenuItemResponseDTO.getPrice()*quantity;
        cartItemTotalTax = customerRestaurantMenuItemResponseDTO.getTaxAmount()*quantity;
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
