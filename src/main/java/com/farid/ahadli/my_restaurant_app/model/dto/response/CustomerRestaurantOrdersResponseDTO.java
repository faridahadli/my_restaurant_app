package com.farid.ahadli.my_restaurant_app.model.dto.response;

import com.farid.ahadli.my_restaurant_app.model.DiningOption;
import com.farid.ahadli.my_restaurant_app.model.OrderStatus;
import com.farid.ahadli.my_restaurant_app.model.PaymentMethod;
import com.farid.ahadli.my_restaurant_app.model.TableEnum;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Data
@Builder
public class CustomerRestaurantOrdersResponseDTO {

    Long id;

    Instant orderTime;

    DiningOption diningOption;

    PaymentMethod paymentMethod;

    TableEnum table;

    Double totalPrice;

    Double totalTax;

    OrderStatus orderStatus;

    List<CustomerRestaurantOrderMenuItemResponseDTO>  restaurantOrderMenuItemResponseDTOList;


}
