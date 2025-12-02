package com.farid.ahadli.my_restaurant_app.model.dto.response;


import com.farid.ahadli.my_restaurant_app.model.CartItem;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.Map;
import java.util.Set;

@FieldDefaults(makeFinal = true)
@Data
@Builder
public class CustomerCartResponseDTO {
    Double totalPrice;
    public Map<Long,CustomerCartItemResponseDTO> orders;

}
