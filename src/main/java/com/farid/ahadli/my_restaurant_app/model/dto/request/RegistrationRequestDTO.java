package com.farid.ahadli.my_restaurant_app.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegistrationRequestDTO {
    @NotBlank
    @NotNull
    String username;

    @NotBlank
    @NotNull
    String password;

    @NotBlank
    @NotNull
    String roles;
}
