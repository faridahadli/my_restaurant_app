package com.farid.ahadli.my_restaurant_app.validation;

import com.farid.ahadli.my_restaurant_app.model.TaxType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ProperTaxTypeValidator.class)
public @interface ProperTaxType {

    String message () default  "Must be a valid tax type";
    TaxType [] AllowedTaxTypes() default {};
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
