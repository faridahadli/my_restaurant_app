package com.farid.ahadli.my_restaurant_app.validation;

import com.farid.ahadli.my_restaurant_app.model.TableEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class ProperTableValidator implements ConstraintValidator<ProperTable, TableEnum> {

    TableEnum allowedTables [];

    @Override
    public void initialize(ProperTable constraintAnnotation) {
      allowedTables = constraintAnnotation.allowedTables().length == 0 ? TableEnum.values() : constraintAnnotation.allowedTables();
    }

    @Override
    public boolean isValid(TableEnum tableEnum, ConstraintValidatorContext constraintValidatorContext) {
        return Set.of(allowedTables).contains(tableEnum);
    }
}
