package com.farid.ahadli.my_restaurant_app.model.dto.request;


import com.farid.ahadli.my_restaurant_app.model.DiningOption;
import com.farid.ahadli.my_restaurant_app.model.PaymentMethod;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerCreateOrderRequestDTO {

    @NotNull
    @NotEmpty
    DiningOption diningOption;

    @NotNull
    @NotEmpty
    PaymentMethod paymentMethod;



}
