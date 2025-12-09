package com.farid.ahadli.my_restaurant_app.model.dto.request;

import com.farid.ahadli.my_restaurant_app.model.OrderStatus;
import com.farid.ahadli.my_restaurant_app.validation.ProperStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KitchenUpdateOrderRequestDTO {
    @NotBlank
    @NotNull
    @ProperStatus(acceptedStatus = {OrderStatus.READY,OrderStatus.PREPARING},
            message = "Kitchen can only set \"READY\" and \"PREPARING\" "
    )
    OrderStatus kitchenStatus;
}
