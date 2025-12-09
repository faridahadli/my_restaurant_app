package com.farid.ahadli.my_restaurant_app.validation;

import com.farid.ahadli.my_restaurant_app.model.OrderStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class ProperStatusValidator implements ConstraintValidator<ProperStatus, OrderStatus> {

    OrderStatus [] acceptedStatus;
    @Override
    public void initialize(ProperStatus constraintAnnotation) {
        acceptedStatus = constraintAnnotation.acceptedStatus().length == 0 ? OrderStatus.values() : constraintAnnotation.acceptedStatus();
    }


    @Override
    public boolean isValid(OrderStatus status, ConstraintValidatorContext constraintValidatorContext) {
        return Set.of(acceptedStatus).contains(status);
    }
}
