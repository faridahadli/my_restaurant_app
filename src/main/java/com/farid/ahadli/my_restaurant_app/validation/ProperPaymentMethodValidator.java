package com.farid.ahadli.my_restaurant_app.validation;

import com.farid.ahadli.my_restaurant_app.model.PaymentMethod;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class ProperPaymentMethodValidator implements ConstraintValidator<ProperPaymentMethod, PaymentMethod> {

    PaymentMethod [] allowedMethods;

    @Override
    public void initialize(ProperPaymentMethod constraintAnnotation) {
        allowedMethods = constraintAnnotation.allowedPaymentMethods().length ==0 ? PaymentMethod.values() : constraintAnnotation.allowedPaymentMethods();
    }

    @Override
    public boolean isValid(PaymentMethod paymentMethod, ConstraintValidatorContext constraintValidatorContext) {
        return Set.of(allowedMethods).contains(paymentMethod);
    }
}
