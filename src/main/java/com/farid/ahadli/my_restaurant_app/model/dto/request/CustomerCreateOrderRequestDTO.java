package com.farid.ahadli.my_restaurant_app.model.dto.request;


import com.farid.ahadli.my_restaurant_app.model.DiningOption;
import com.farid.ahadli.my_restaurant_app.model.PaymentMethod;
import com.farid.ahadli.my_restaurant_app.model.TableEnum;
import com.farid.ahadli.my_restaurant_app.validation.ProperDiningOption;
import com.farid.ahadli.my_restaurant_app.validation.ProperPaymentMethod;
import com.farid.ahadli.my_restaurant_app.validation.ProperTable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerCreateOrderRequestDTO {

    @NotNull
    @ProperDiningOption
    DiningOption diningOption;

    @NotNull
    @ProperPaymentMethod
    PaymentMethod paymentMethod;


    @NotNull
    @ProperTable
    TableEnum table;



}
