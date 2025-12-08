package com.farid.ahadli.my_restaurant_app.model.dto.request;


import com.farid.ahadli.my_restaurant_app.model.MeasureUnits;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantMenuItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Data
@Builder
public class AdminAddRestaurantIngredientsRequestDTO {
    @NotBlank
    String name;

    @NotNull
    Boolean Allergen;

    @NotNull
    MeasureUnits measureUnits;

    @NotNull
    Double pricePerUnit;
}
