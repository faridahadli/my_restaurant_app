package com.farid.ahadli.my_restaurant_app.model.dto.request;


import com.farid.ahadli.my_restaurant_app.validation.ProperTaxType;
import com.farid.ahadli.my_restaurant_app.model.TaxType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Data
public class AdminRestaurantAddMenuItemRequestDTO {


    @NotBlank
    String name;

    @NotNull
    Double price;

    @NotEmpty
    Set<Long> ingredientIds;

    @ProperTaxType
    TaxType taxType;
}
