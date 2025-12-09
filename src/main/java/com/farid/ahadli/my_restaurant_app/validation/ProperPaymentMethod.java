package com.farid.ahadli.my_restaurant_app.validation;

import com.farid.ahadli.my_restaurant_app.model.PaymentMethod;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ProperPaymentMethodValidator.class)
public @interface ProperPaymentMethod {

    PaymentMethod [] allowedPaymentMethods() default {};
    String message() default "Invalid payment method";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
