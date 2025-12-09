package com.farid.ahadli.my_restaurant_app.model.dto.request;


import com.farid.ahadli.my_restaurant_app.model.MeasureUnits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
