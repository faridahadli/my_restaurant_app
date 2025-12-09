package com.farid.ahadli.my_restaurant_app.validation;


import com.farid.ahadli.my_restaurant_app.model.DiningOption;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ProperDiningOptionValidator.class)
public @interface ProperDiningOption {

    DiningOption [] allowedOptions() default {};
    String message( ) default "Invalid dining option";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
