package com.farid.ahadli.my_restaurant_app;

import com.farid.ahadli.my_restaurant_app.model.TaxType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Set;

public class ProperTaxTypeValidator implements ConstraintValidator<ProperTaxType, TaxType> {

    TaxType [] allowed_taxTypes;
    @Override
    public void initialize(ProperTaxType constraintAnnotation) {
        allowed_taxTypes = constraintAnnotation.AllowedTaxTypes().length == 0 ? TaxType.values() : constraintAnnotation.AllowedTaxTypes();

    }

    @Override
    public boolean isValid(TaxType taxType, ConstraintValidatorContext constraintValidatorContext) {
       return Set.of(allowed_taxTypes).contains(taxType);

    }
}
