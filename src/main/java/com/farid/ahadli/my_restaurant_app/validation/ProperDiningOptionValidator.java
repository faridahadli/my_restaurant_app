package com.farid.ahadli.my_restaurant_app.validation;

import com.farid.ahadli.my_restaurant_app.model.DiningOption;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class ProperDiningOptionValidator  implements ConstraintValidator<ProperDiningOption, DiningOption> {

    DiningOption [] allowedOptions;

    @Override
    public void initialize(ProperDiningOption constraintAnnotation) {
        allowedOptions = constraintAnnotation.allowedOptions().length == 0 ? DiningOption.values() : constraintAnnotation.allowedOptions();
    }

    @Override
    public boolean isValid(DiningOption diningOption, ConstraintValidatorContext constraintValidatorContext) {
       return Set.of(allowedOptions).contains(diningOption);
    }

}
