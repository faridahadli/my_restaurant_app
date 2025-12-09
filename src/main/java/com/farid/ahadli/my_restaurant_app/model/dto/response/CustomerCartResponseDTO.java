package com.farid.ahadli.my_restaurant_app.model.dto.response;



import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.Map;
@FieldDefaults(makeFinal = true)
@Data
@Builder
public class CustomerCartResponseDTO {
    Double totalPrice;
    public Map<Long,CustomerCartItemResponseDTO> orders;

}
