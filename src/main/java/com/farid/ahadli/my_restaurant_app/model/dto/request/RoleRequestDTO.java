package com.farid.ahadli.my_restaurant_app.model.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class RoleRequestDTO {
    @NotBlank
    String role;
}
