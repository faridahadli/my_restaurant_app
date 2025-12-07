package com.farid.ahadli.my_restaurant_app;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class KitchenOrderStatusValidator implements ConstraintValidator<ProperStatus, String> {

    String [] acceptedStatus;
    @Override
    public void initialize(ProperStatus constraintAnnotation) {
        acceptedStatus = constraintAnnotation.acceptedStaus();
    }

    @Override
    public boolean isValid(String status, ConstraintValidatorContext constraintValidatorContext) {
        return ! Arrays.stream(acceptedStatus).filter(s -> s.equals(status)).toList().isEmpty();
    }
}
