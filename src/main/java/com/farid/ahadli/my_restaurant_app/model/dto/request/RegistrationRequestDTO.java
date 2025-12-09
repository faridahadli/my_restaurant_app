package com.farid.ahadli.my_restaurant_app.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegistrationRequestDTO {
    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotBlank
    String roles;
}
