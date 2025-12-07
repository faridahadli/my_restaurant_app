package com.farid.ahadli.my_restaurant_app;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = KitchenOrderStatusValidator.class)
public @interface ProperStatus {
    String message() default "Invalid status";
    String[] acceptedStaus() default {"READY", "PREPARING"};
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
