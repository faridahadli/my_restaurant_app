package com.farid.ahadli.my_restaurant_app.validation;
import com.farid.ahadli.my_restaurant_app.model.OrderStatus;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ProperStatusValidator.class)
public @interface ProperStatus {
    String message() default "Invalid status";
    OrderStatus[] acceptedStatus() default {};
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
